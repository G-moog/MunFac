package com.kingmonkey.MunFac.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String main() {
        System.out.println("여기 오나?");
        return "main/main.html";
    }
}
