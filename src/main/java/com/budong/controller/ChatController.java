package com.budong.controller;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wjddp
 * 채팅 화면 메인 
 */
@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chatHome.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "chatHome";
	} 
	
	
	@RequestMapping(value = "/moveChatRoom.do", method = RequestMethod.POST)
	@ResponseBody
	public String  moveChatRoom(HttpServletRequest req,HttpServletResponse resp	) {
		String roomName = req.getParameter("roomName");
		logger.info("\n이동할 방이름 : " + roomName); 
		
		HttpSession session = req.getSession(); 
		session.setAttribute("roomName", roomName); //세션에 방이름 저장 
		
		resp.setContentType("text/html; charset=UTF-8");
		return roomName; 
	}

	
	
}
