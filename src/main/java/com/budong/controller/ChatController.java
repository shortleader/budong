package com.budong.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.budong.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wjddp
 * 채팅 컨트롤러
 */
@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	// 채팅 홈 화면 
	@RequestMapping(value = R.mapping.chat_home, method = RequestMethod.GET)
	public String home(Locale locale, Model model) { 
		
		logger.info("Welcome home! The client locale is {}.", locale);  
		return R.path.chat_home;
	} 
	
	
	//채팅 방 이동 
	@RequestMapping(value = R.mapping.move_chat_room, method = RequestMethod.POST)
	@ResponseBody
	public String  moveChatRoom(HttpServletRequest req,HttpServletResponse resp	) {
		HttpSession session = req.getSession();  
		String roomName = req.getParameter("roomName");  //이동할 방이름 
		
		session.setAttribute("prevRoom", session.getAttribute("roomName")); //이동하기 이전 방 
		session.setAttribute("roomName", roomName); //이동할 방 
		
		logger.info("이동할 방이름 : " + session.getAttribute("roomName")); 
		resp.setContentType("text/html; charset=UTF-8");
		return roomName; 
	}
}
