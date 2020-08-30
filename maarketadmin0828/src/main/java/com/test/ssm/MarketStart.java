package com.test.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.test.ssm.dao")
@ServletComponentScan    //扫描过滤器
public class MarketStart {
    public static void main(String[] args) {
        SpringApplication.run(MarketStart.class,args);
    }
}
