package com.kingmonkey.munfac.authority.service;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.dto.TokenDTO;
import com.kingmonkey.munfac.authority.entity.Authority;
import com.kingmonkey.munfac.authority.repository.AuthorityRepository;
import com.kingmonkey.munfac.exception.LoginFailedException;
import com.kingmonkey.munfac.jwt.TokenProvider;
import com.kingmonkey.munfac.member.dto.MemberDTO;
import com.kingmonkey.munfac.member.entity.Member;
import com.kingmonkey.munfac.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private static final Logger log = LoggerFactory.getLogger(AuthorityServiceImpl.class);
    private final AuthorityRepository authorityRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final ModelMapper modelMapper ;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository,
                                ModelMapper modelMapper,
                                MemberRepository memberRepository,
                                PasswordEncoder passwordEncoder,
                                TokenProvider tokenProvider) {
        this.authorityRepository = authorityRepository;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorityDTO getAuth(int authNo) {
        Optional<Authority> authority = authorityRepository.findById(authNo);
        log.info("[AuthorityServiceImpl] getAuth. Optional<Authority> authority : " + authority.toString());

        return modelMapper.map(authority, AuthorityDTO.class);
    }

    @Override
    public Object login(MemberDTO memberDTO) {
        log.info("[AuthService] 로그인 스따또~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("[AuthService] {}", memberDTO);


        // 1. 사번 조회
        Optional<Member> member = memberRepository.findById(memberDTO.getMemberNo());

        if(member == null) {
            throw new LoginFailedException("존재하지 않는 사원번호입니다.");
        }

        // 2. 비밀번호 매칭
        //    (BCrypt 암호화 라이브러리 bean을 의존성 주입받아 처리하는 부분부터 security 설정 부분을 추가해보자.)
        //  mathces(평문, 다이제스트)
        if(!passwordEncoder.matches(memberDTO.getMemberPw(), member.get().getMemberPw())){
            log.info("[AuthService] 패스워드 틀려쪄염!!!!");
            throw new LoginFailedException("잘못된 비밀번호입니다.");
        }


        // 3. 토큰 발급
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(member.get());
        log.info("[AuthService] tokenDTO{}", tokenDTO);

        log.info("[AuthService] 로그인 끄으으으으으으으으읕~~~~~~~~~~~~~~~~");
        return tokenDTO;

    }

}
