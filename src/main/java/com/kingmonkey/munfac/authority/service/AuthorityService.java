package com.kingmonkey.munfac.authority.service;

import com.kingmonkey.munfac.member.dto.MemberDTO;

public interface AuthorityService {


    public Object getAuth(int authNo);

    public Object login(MemberDTO memberDTO);
}
