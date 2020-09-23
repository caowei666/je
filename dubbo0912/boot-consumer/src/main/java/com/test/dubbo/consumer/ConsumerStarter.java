package com.test.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStarter.class);
    }
}
