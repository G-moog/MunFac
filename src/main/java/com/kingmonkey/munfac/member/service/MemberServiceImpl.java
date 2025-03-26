package com.kingmonkey.munfac.member.service;

import com.kingmonkey.munfac.member.dto.MemberDTO;
import com.kingmonkey.munfac.member.entity.Member;
import com.kingmonkey.munfac.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, ModelMapper modelMapper){
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MemberDTO findMemberById(int memberNo) {
        Optional<Member> member = memberRepository.findById(memberNo);

        return modelMapper.map(member, MemberDTO.class);
    }
}
