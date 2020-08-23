package com.test.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${my.user.name}")
    private String name;
    @RequestMapping("index")
    public String hello(){
        System.out.println(name);
        return "hello Boot";
    }
}
