package com.budong.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.budong.controller.ChatController;

/**
 * 
 * @author wjddp 사용자 채팅
 */
@ServerEndpoint(value = "/chatting", configurator = GetHttpSessionForWebSocket.class)
public class WebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
//	private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	private HttpSession httpSession;

	// 클라이언트 연결
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {

		// 웹소켓 연결시 httpSesion값 가져온다.
		httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());

		logger.info("WebSocket 연결 확인  : " + session.getId());
		clients.add(session);
	}

	// 메시지 전송
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		logger.info("WebSocket onMessage : " + message);
		logger.info(httpSession.getAttribute("userId") + "님의 현재방  : " + httpSession.getAttribute("roomName"));

		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

	// 클라이언트와 연결 해제
	@OnClose
	public void onClose(Session session) {
		logger.info("WebSocket 연결 해제  : " + session.getId());
		clients.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable exception) throws Exception {
		logger.info("WebSocket onError");
	}

}