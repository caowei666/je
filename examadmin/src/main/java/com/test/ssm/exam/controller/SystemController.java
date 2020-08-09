package com.test.ssm.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
    @RequestMapping("login.html")
    public String login(){
        return "login";
    }
}
