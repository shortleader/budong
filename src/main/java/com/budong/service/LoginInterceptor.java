package com.budong.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.budong.controller.ChatController;
import com.budong.model.dto.MemberDTO;
import com.budong.service.interfaces.MainService;

//자동 로그인 처리 인터셉터 
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	private MainServiceImpl service;

	@Autowired
	public void setService(MainServiceImpl service) {
		this.service = service;
	}

	// 컨트롤러에 가기전에 수행
	// return true : 컨트롤러 uri로 이동을 허가 
	// return false : 컨트롤러 uri로 이동을 허가하지 않음 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		if (obj == null) { // 연결된 세션 없을 경우
			Cookie cookie = WebUtils.getCookie(request, "loginCookie"); // 저장된 쿠키를 꺼냄
			String sessionId = cookie.getValue(); // 세션 ID

			MemberDTO dto = service.checkSessionValid(sessionId);

			if (dto != null) { // 전에 로그인 된 적이 있는 세션일경우 dto를 세션에 저장한다.
				session.setAttribute("login", dto);
				logger.info("로그인 된 정보 있음 ");
				return true;
			} 
			
			//연결된 세션도 없고 로그인 된 기록도 없을 경우
			//로그인 화면으로 보낸다. 
			response.sendRedirect("/chatHome.do"); 
			return false;  //컨트롤러로 못가게 false 
		} 
		return true; 
	}

	// 컨트롤러가 수행되고 화면 보여지기 직전에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
