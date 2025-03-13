package com.kingmonkey.MunFac.solvingpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("solvingpage")
public class SolvingPageController {

    @GetMapping("/")
    public String solvingpage() {
        return "solvingPage.html";
    }
}
