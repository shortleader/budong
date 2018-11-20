package com.budong.service;

import com.budong.model.dto.MemberDTO;
import com.budong.model.interfaces.MemberDAO;
import com.budong.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {
    private final MemberDAO memberDAO;

    @Autowired
    public MainServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public boolean login(String id, String password) {
        return memberDAO.login(new MemberDTO(id, password)) != null;
    }
}
