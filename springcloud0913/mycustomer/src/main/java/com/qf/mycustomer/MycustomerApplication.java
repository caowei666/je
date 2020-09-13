package com.qf.mycustomer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class MycustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycustomerApplication.class, args);
    }

//    @Bean   //创建一个restTemplate对象放置到spring上下文
//    @LoadBalanced  //客户端负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }


    //访问serch的规则(负载均衡的策略)随机 默认为轮询
    //还可以通过配置文件写
//    @Bean
//    public IRule ribbonRule(){
//        return new RandomRule();
//    }
}
