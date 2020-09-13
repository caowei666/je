package com.qf.mysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MysearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysearchApplication.class, args);
    }

}
