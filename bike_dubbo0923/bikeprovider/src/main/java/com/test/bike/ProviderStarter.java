package com.test.bike;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.test.bike.dao")
public class ProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStarter.class);
    }
}
