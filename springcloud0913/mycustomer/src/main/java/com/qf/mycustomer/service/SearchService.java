package com.qf.mycustomer.service;

import com.qf.mycustomer.bean.Customer;
import com.qf.mycustomer.util.SearchServiceFallback;
import com.qf.mycustomer.util.SearchServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(value = "SEARCH",fallback = SearchServiceFallback.class)  //配置需要访问服务名称
@FeignClient(value = "SEARCH",fallbackFactory = SearchServiceFallbackFactory.class)  //配置需要访问服务名称
public interface SearchService {
    @GetMapping("/search")  //配置需要访问的服务的url
    String search();

    //此处接口中所有的参数注解中必须要写对应的参数名称

    @GetMapping("/search/{id}")
    Customer findById(@PathVariable("id") Integer id);

    @GetMapping("/getCustomer")
    Customer getCustomer(@RequestParam("id") Integer id, @RequestParam String name);

    @PostMapping("/save")
    Customer save(@RequestBody Customer customer);
}
