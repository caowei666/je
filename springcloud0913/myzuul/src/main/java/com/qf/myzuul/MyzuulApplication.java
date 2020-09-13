package com.qf.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy  //默认使用服务名进行转发
public class MyzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyzuulApplication.class, args);
    }

}
