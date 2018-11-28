package com.budong.service.interfaces;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting")
public interface ChatSocket {

	@OnMessage
	public void onMessage(String message, Session session); // 클라이언트에게 메시지 전송

	@OnOpen
	public void onOpen(Session session); // 클라이언트가 서버에 연결 됐을 때

	@OnClose
	public void onClose(Session session); // 클라이언트와 연결이 끊어졌을 때

	@OnClose
	public void onError(Session session); // 에러 발생했을 때

}
