package com.qf.mycustomer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.mycustomer.bean.Customer;
import com.qf.mycustomer.service.SearchService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CustomerController {
//    @Resource
//    private RestTemplate restTemplate;

//    @Resource
//    private EurekaClient eurekaClient;

    @Resource
    private SearchService searchService;
    @GetMapping("/custom")
    public String custom(){
        //直接跳过中心访问url
        //String result = restTemplate.getForObject("http://localhost:9001/search", String.class);

        //通过中心得到服务注册的实例信息
        //InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SEARCH", false);
        //通过实例信息得到注册的url
        //String homePageUrl = instanceInfo.getHomePageUrl();
        //System.out.println(homePageUrl);
        //通过获取的url去访问对应的服务
        //String result = restTemplate.getForObject(homePageUrl + "/search", String.class);

//        String result = restTemplate.getForObject("http://SEARCH/search", String.class);
//
//        return result;

        String search = searchService.search();
        return search;
    }

    @GetMapping("/search/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public Customer findById(@PathVariable("id") Integer id){
        int i = 5/0;
        return searchService.findById(id);
    };
    public Customer findByIdFallback(Integer id){
        return new Customer(-1,"",0);
    };

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam("id") Integer id, @RequestParam String name){
        return searchService.getCustomer(id,name);
    };

    @GetMapping("/save")
    public Customer save(Customer customer){
        return searchService.save(customer);
    };
}
