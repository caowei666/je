package com.qf.mycustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MycustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycustomerApplication.class, args);
    }

    @Bean   //创建一个restTemplate对象放置到spring上下文
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
