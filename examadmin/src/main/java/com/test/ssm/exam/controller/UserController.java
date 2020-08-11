package com.test.ssm.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/user.html")
public class UserController {
    @RequestMapping
    public String page(){
        return "user";
    }
}
