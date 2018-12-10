package com.budong.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budong.controller.ChatController;
import com.budong.model.dto.MemberDTO;
import com.budong.model.interfaces.MemberDAO;
import com.budong.service.interfaces.MainService;

@Service
public class MainServiceImpl implements MainService {
	private final MemberDAO memberDAO;
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	public MainServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	// 아이디 중복 확인
	@Override
	public boolean isAvailableId(String id) { 
		int rslt = memberDAO.isAvailableId(id);  
		
		if(rslt ==0 ) {
			return true; 
		}else {
			return false; 
		}
	}

	//자동 로그인에 체크했을 경우 
	//아이디, 세션ID, 세션유효시간을 디비에 저장한다. 
	@Override
	public void keepLogin(String mem_id, String session_key, Date session_limit) {
		memberDAO.keepLogin(mem_id, session_key, session_limit);
	}

	// 회원 가입
	@Override
	public int insertMember(MemberDTO dto) {
		return memberDAO.insertMember(dto);
	}

	// 로그인
	@Override
	public MemberDTO login(String mem_id, String mem_pw) {
		MemberDTO dto = memberDAO.login(new MemberDTO(mem_id, mem_pw));

		if (dto == null) {
			return null;
		} else {
			return dto;
		}
	}

	@Override
	public MemberDTO checkSessionValid(String sessionId) {
		
		MemberDTO dto = memberDAO.checkSessionValid(sessionId); 
		
		if(dto==null) {
			return null; 
		}else {
			return dto; 
		}
	}
}
