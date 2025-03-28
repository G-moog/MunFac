package com.kingmonkey.munfac.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @GetMapping("/main")
    public String main() {
        System.out.println("여기 오나?");
        return "main/main.html";
    }
}
