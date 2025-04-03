package com.kingmonkey.munfac.member.controller;

import com.kingmonkey.munfac.member.dto.MemberDTO;
import com.kingmonkey.munfac.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/loginPage")
    public ModelAndView loginPage (){

        log.info("[MemberController] loginPage Activated");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginPage.html");

        return mv;
    }

    @ResponseBody
    @PostMapping("/getMember")
    public MemberDTO getMember(@RequestParam int memberNo){
        MemberDTO memberDTO = memberService.findMemberById(memberNo);

        return memberDTO;
    }
}
