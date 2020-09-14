package com.qf.mysearch.controller;

import com.qf.mysearch.bean.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {
    @Value("${server.port}")
    private String port;

    @Value("${test_config}")
    private String name;

    @GetMapping("/search")
    public String search(){
        //int i = 5/0;
        System.out.println("search:"+port);
        return "search:"+port+"------"+ name;
    }

    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id){
        return new Customer(1,"张三",23);
    }

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id,@RequestParam String name){
        return new Customer(id,name,23);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){  //服务直接传递数据是json，需要@RequestBody转换成对象
        return customer;
    }
}
