package com.test.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class HelloService implements com.test.dubbo.service.HelloService {
    @Override
    public String sayHello(String name) {
        return "22hello "+ name;
    }
}
