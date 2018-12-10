package com.budong.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.budong.controller.ChatController;
import com.budong.model.dto.MemberDTO;

/**
 * 
 * @author wjddp 사용자 채팅
 *  - 사용자가 방 입장시 웹소켓 세션을 생성한다.
 *  - 방을 이동할경우 기존의 웹소켓 세션을 제거하고 , 새로운 웹소켓 세션을 생성한다.
 * 
 */
@ServerEndpoint(value = "/chatting", configurator = GetHttpSessionForWebSocket.class)
public class WebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	private boolean closePrevSession = false; 
	private HttpSession httpSession;
	private static Map<Session, HttpSession> map = new ConcurrentHashMap<>(); // 웹소켓 세션, HttpSession
	private static Map<Session, String> room = new ConcurrentHashMap<>(); // 웹소켓 세션, 방 이름
	
	// 클라이언트 연결
	@OnOpen
	public void onOpen(Session currentSession, EndpointConfig config) throws IOException {
		logger.info("======================================");
		logger.info("WebSocket 연결 확인  : " + currentSession.toString());

		// 웹소켓 연결시 httpSesion값 가져온다.
		httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());

		Set<Session> key = map.keySet();
		Iterator<Session> it = key.iterator();
		Session prevSession = null;

		String roomName = (String) httpSession.getAttribute("roomName");

		map.put(currentSession, httpSession);
		room.put(currentSession, roomName); // 현재 웹소켓 세션, 방이름 저장
		
		while (it.hasNext()) {
			prevSession = it.next();

			MemberDTO dto = (MemberDTO) map.get(prevSession).getAttribute("login");
			MemberDTO dto2 = (MemberDTO) map.get(currentSession).getAttribute("login");

			// 기존에 연결된 HTTP세션과 mem_id 값이 동일한데
			// 서로 다른 웹 소켓 일경우
			// 이전 웹소켓 연결을 종료 시킴
			if (dto.getMem_id().equals(dto2.getMem_id()) && prevSession != currentSession) {
				closePrevSession = true;
				break;
			}
		}

		if (closePrevSession) {
			closePrevSession = false;
			map.remove(prevSession);
			sendRoomExitMsg();

			room.remove(prevSession);
			prevSession.close();
			sendEnterRoomMsg();
		} else {
			sendEnterRoomMsg();
		}

		logger.info("session  : " + currentSession.toString() + ", httpsession : " + map.get(currentSession).getId());
	}

	// 메시지 전송
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		logger.info("\n WebSocket onMessage : " + message);

		JSONObject jsonObject = new JSONObject(message);
		String roomName = jsonObject.getString("roomName"); // 현재 방이름

		Set<Session> key = room.keySet();
		Iterator<Session> it = key.iterator();

		// 같은 방에 있는 사용자에게 메시지를 전송
		while (it.hasNext()) {
			Session s = it.next();
			if (!roomName.equals("") && room.get(s).equals(roomName)) {
				s.getBasicRemote().sendText(message);
			}
		}
	}

	// 클라이언트와 연결 해제
	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("======================================");
		logger.info("WebSocket 연결 해제  : " + session.toString());
		logger.info("session 수  : " + map.size());
	}

	// 에러 발생시 onClose 호출
	@OnError
	public void onError(Session session, Throwable exception) {
		logger.error("WebSocket onError : " + exception.toString());
	}

	public void sendRoomExitMsg() throws IOException {
		MemberDTO dto = (MemberDTO) httpSession.getAttribute("login");
		String prevRoom = (String) httpSession.getAttribute("prevRoom");

		/*
		 * type : 메시지 타입
		 *  id : 퇴장할 사람 id 
		 *  roomName : 퇴장할 방 이름
		 */
		JSONObject jsonObject = new JSONObject();
		jsonObject.append("type", "exitMsg");
		jsonObject.append("id", dto.getMem_id());
		jsonObject.append("roomName", prevRoom);

		Set<Session> key = room.keySet();
		Iterator<Session> it = key.iterator();

		// 같은방에 있는 사용자에게 퇴장 메시지 전송
		while (it.hasNext()) {
			Session s = it.next();
			if (!prevRoom.equals("") && room.get(s).equals(prevRoom)) {
				s.getBasicRemote().sendText(jsonObject.toString());
			}
		}
	}

	public void sendEnterRoomMsg() throws IOException {
		MemberDTO dto = (MemberDTO) httpSession.getAttribute("login");
		String roomName = (String) httpSession.getAttribute("roomName");
		/*
		 * type : 메시지 타입 
		 * id : 입장한 사람 id 
		 * roomName : 방 이름
		 */
		JSONObject jsonObject = new JSONObject();
		jsonObject.append("type", "enterMsg");
		jsonObject.append("id", dto.getMem_id());
		jsonObject.append("roomName", roomName);

		// 같은 방 사용자에게 입장 메시지를 보낸다.
		Set<Session> key = room.keySet();
		Iterator<Session> it = key.iterator();

		while (it.hasNext()) {
			Session session = it.next();
			if (!roomName.equals("") && room.get(session).equals(roomName)) {
				session.getBasicRemote().sendText(jsonObject.toString());
			}
		}
	}
}