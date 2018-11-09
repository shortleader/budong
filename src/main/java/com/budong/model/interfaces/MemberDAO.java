package com.budong.model.interfaces;

import com.budong.model.dto.MemberDTO;

public interface MemberDAO {
    MemberDTO login(MemberDTO dto);
}
