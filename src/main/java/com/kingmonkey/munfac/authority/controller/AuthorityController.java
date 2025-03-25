package com.kingmonkey.munfac.authority.controller;

import com.kingmonkey.munfac.authority.dto.AuthorityDTO;
import com.kingmonkey.munfac.authority.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorityController {

    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @ResponseBody
    @PostMapping("/getAuth")
    public AuthorityDTO getAuthority(@RequestParam int authNo) {
        AuthorityDTO authorityDTO = (AuthorityDTO) authorityService.getAuth(authNo);

        return authorityDTO;
    }

}
