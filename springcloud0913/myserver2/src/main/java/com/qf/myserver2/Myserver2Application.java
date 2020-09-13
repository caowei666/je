package com.qf.myserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Myserver2Application {

    public static void main(String[] args) {
        SpringApplication.run(Myserver2Application.class, args);
    }

}
