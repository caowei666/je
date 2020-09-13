package com.qf.mycustomer.util;

import com.qf.mycustomer.bean.Customer;
import com.qf.mycustomer.service.SearchService;
import org.springframework.stereotype.Component;

@Component
public class SearchServiceFallback implements SearchService {
    @Override
    public String search() {
        return "search出错了";
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer getCustomer(Integer id, String name) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }
}
