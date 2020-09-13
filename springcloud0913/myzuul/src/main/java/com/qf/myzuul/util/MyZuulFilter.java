package com.qf.myzuul.util;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class MyZuulFilter extends ZuulFilter {
    //过滤器什么时候执行
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("过滤器正在执行");
        return null;
    }
}
