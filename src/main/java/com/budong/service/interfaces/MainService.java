package com.budong.service.interfaces;

import java.util.Date;

import com.budong.model.dto.MemberDTO;

public interface MainService {
    public MemberDTO login(String id, String password);  //로그인 
    
    //자동 로그인에 체크 한 경우 디비테이블에 사용자의 세션ID, 세션 유효시간을 저장한다. 
    public void keepLogin(String mem_id, String session_key, Date session_limit); 
    
    public MemberDTO checkSessionValid(String sessionId); 
    
    public boolean isAvailableId(String id); // 아이디 중복 확인 

	public int insertMember(MemberDTO dto); // 회원 등록  
	
}