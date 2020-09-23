package com.test.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.test.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name){
        return helloService.sayHello(name);
    }
}
