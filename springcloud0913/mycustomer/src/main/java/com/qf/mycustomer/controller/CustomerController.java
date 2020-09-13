package com.qf.mycustomer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CustomerController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/custom")
    public String custom(){
        //直接跳过中心访问url
        //String result = restTemplate.getForObject("http://localhost:9001/search", String.class);

        //通过中心得到服务注册的实例信息
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("search", false);
        //通过实例信息得到注册的url
        String homePageUrl = instanceInfo.getHomePageUrl();
        System.out.println(homePageUrl);
        //通过获取的url去访问对应的服务
        String result = restTemplate.getForObject(homePageUrl + "/search", String.class);

        return result;
    }
}
