package com.qf.myserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Myserver1Application {

    public static void main(String[] args) {
        SpringApplication.run(Myserver1Application.class, args);
    }

}
