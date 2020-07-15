package com.caowei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//精确拦截  /hello.jsp
//后缀拦截   *.jsp
//通配符拦截   /*
@WebFilter(filterName = "MyFilter2",value = "/hello.jsp")
public class MyFilter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("myfilter2过滤前");
        chain.doFilter(req, resp);
        System.out.println("myfilter2过滤后");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
