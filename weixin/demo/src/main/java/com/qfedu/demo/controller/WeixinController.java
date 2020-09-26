package com.qfedu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weixin")
public class WeixinController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("-----------");
        return "我也想你";
    }
}
