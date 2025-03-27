package com.kingmonkey.munfac.authority.controller;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
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

@Controller
@RequestMapping("/auth")
public class AuthorityController {

    private static final Logger log = LoggerFactory.getLogger(AuthorityController.class);
    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
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
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO) {
        log.info("제발 나와라요~ 나와라예~");
        System.out.println("오긴 온다???");
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authorityService.login(memberDTO)));

        /*
         * ResponseEntity의 body메소드를 통해 Response객체의 body에 담기는 ResponseDTO는 JSON문자열이 되고
         * 화면단이 React인 곳으로 가면 결국 Store에 해당 리듀서가 관리하는 state 값이 된다.(가장 중요!!!!!!!!!!)
         */
    }


}
