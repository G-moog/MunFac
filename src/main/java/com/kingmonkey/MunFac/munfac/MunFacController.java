package com.kingmonkey.MunFac.munfac;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/munfac")
public class MunFacController {

    @GetMapping("/eqfactory")
    public String eqFactory() {
        System.out.println("이큐 팩토리 오나?");
        return "eqfactory.html";
    }

    @GetMapping("/mcfactory")
    public String mcFactory() {
        System.out.println("앰씨 팩토리 오나?");
        return "mcfactory.html";
    }

    @GetMapping("/oxfactory")
    public String oxFactory() {
        System.out.println("오엑스 팩토리 오나?");
        return "oxfactory.html";
    }
}
