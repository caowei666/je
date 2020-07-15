package com.caowei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//配置拦截路径
@WebFilter(filterName = "MyFilter",value = "/hello.jsp")
public class MyFilter implements Filter {
    public void destroy() {
        System.out.println("myfilter销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //执行目标资源（放行）
        System.out.println("myfilter过滤前");
        chain.doFilter(req, resp);
        System.out.println("myfilter过滤后");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("myfilter初始化");
    }

}
