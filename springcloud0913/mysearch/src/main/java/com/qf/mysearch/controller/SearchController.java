package com.qf.mysearch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/search")
    public String search(){
        System.out.println("search:"+port);
        return "search:"+port;
    }
}
