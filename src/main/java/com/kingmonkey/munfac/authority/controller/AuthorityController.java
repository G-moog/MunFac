package com.kingmonkey.munfac.authority.controller;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.dto.TokenDTO;
import com.kingmonkey.munfac.authority.service.AuthorityService;
import com.kingmonkey.munfac.common.ResponseDTO;
import com.kingmonkey.munfac.member.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthorityController {

    private static final Logger log = LoggerFactory.getLogger(AuthorityController.class);
    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/custom-login2")
    public String customLoginPage() {
        log.info("커스텀로그인 오나요?");
        return "custom-login2.html";
    }

    @ResponseBody
    @PostMapping("/getAuth")
    public AuthorityDTO getAuthority(@RequestParam int authNo) {
        AuthorityDTO authorityDTO = (AuthorityDTO) authorityService.getAuth(authNo);

        log.info("[Authority Controller] authorityDTO : " + authorityDTO.toString());

        return authorityDTO;
    }



    /* @RequestBody를 통해 RequestBody로 넘어온 Json 문자열을 파싱해서 MemberDTO 속성으로 매핑해 객체로 받아낸다.(회원 아이디, 비밀번호) */
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        log.info("제발 나와라요~ 나와라예~");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(username);
        memberDTO.setMemberPw(password);

        log.info("username : " + username + ",       password : " + password);

        TokenDTO token = (TokenDTO)authorityService.login(memberDTO);

        log.info("token in controller : " + token.toString());

        ModelAndView mv = new ModelAndView();

        mv.setViewName("redirect:/main");
        mv.addObject("token", token);
        log.info("로그인 마지막 파트!!");
        return mv;


    }


}
