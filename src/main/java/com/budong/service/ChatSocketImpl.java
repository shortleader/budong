package com.budong.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 
 * @author wjddp
 * 사용자 채팅
 */
@ServerEndpoint("/chatting")
public class ChatSocketImpl {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}

   	
	@OnOpen
	public void onOpen(Session session) {
		// Add session to the connected sessions set
		System.out.println("session open : " + session); 
		System.out.println("세션 개수 : " + clients.size());
		clients.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		// Remove session from the connected sessions set
		System.out.println("session close : " + session);
		clients.remove(session);
	} 
	 
	@OnError
	public void onError(Session session, Throwable exception) throws Exception {
		
	}
	
}