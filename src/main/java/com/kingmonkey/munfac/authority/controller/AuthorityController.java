package com.kingmonkey.munfac.authority.controller;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
