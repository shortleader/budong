package com.budong.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.budong.controller.ChatController;

/**
 * 
 * @author wjddp 사용자 채팅
 */
public class WebSocketHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	// 클라이언트와 연결
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("WebSocket 연결 확인 ");
		clients.add(session);
	}

	// 서버로 데이터 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("Websocket HandleTextMessage : " + message.getPayload());

		synchronized (clients) {
			for (WebSocketSession sess : clients) {
				if (!sess.equals(session)) {
					sess.sendMessage(new TextMessage(message.getPayload()));
				}
			}
		}
	}

	// 클라이언트와 연결 해제 됐을 떄
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("Websocket 연결 해제");
		clients.remove(session);
	}
}