package com.qf.mycustomer.util;

import com.qf.mycustomer.service.SearchService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SearchServiceFallbackFactory implements FallbackFactory<SearchService> {
    @Resource
    private SearchServiceFallback searchServiceFallback;
    @Override
    public SearchService create(Throwable throwable) {
        throwable.printStackTrace();
        return searchServiceFallback;
    }
}
