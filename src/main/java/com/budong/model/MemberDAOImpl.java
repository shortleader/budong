package com.budong.model;

import com.budong.model.dto.MemberDTO;
import com.budong.model.interfaces.MemberDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private final SqlSessionTemplate mybatis;
	private static final String Namespace = "com.budong.model.interfaces.MemberDAO.";

	@Autowired
	public MemberDAOImpl(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public MemberDTO login(MemberDTO dto) {
		return mybatis.selectOne(Namespace + "login", dto);
	}
	
	@Override
	public int isAvailableId(String mem_id) { 
		return mybatis.selectOne(Namespace+"checkId",mem_id);
	}
	@Override
	public void keepLogin(String mem_id, String session_key, Date session_limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 데이터를 map에 넣어서 전송한다.
		// map의 키 이름이 .xml 의 변수명이랑 같아야 자동매핑 된다.
		map.put("mem_id", mem_id);
		map.put("session_key", session_key);
		map.put("session_limit", session_limit);

		mybatis.update(Namespace + "keepLogin", map);
	}

	@Override
	public MemberDTO checkSessionValid(String sessionId) {

		return mybatis.selectOne(Namespace + "checkSessionValid", sessionId);
	}

	public int insertMember(MemberDTO dto) {
		return mybatis.insert(Namespace + "insertMember", dto);
	}
}
