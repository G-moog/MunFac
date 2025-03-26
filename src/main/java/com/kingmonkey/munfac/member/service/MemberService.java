package com.kingmonkey.munfac.member.service;

import com.kingmonkey.munfac.member.dto.MemberDTO;

public interface MemberService {

    public MemberDTO findMemberById(int memberNo);
}
