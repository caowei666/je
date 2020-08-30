package com.test.ssm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.html")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        HttpServletResponse response1 = (HttpServletResponse)response;
        String path = request1.getServletPath();
        if("/login.html".equals(path) || "/doLogin.html".equals(path)){
            chain.doFilter(request1,response1);
            return;
        }
        if(request1.getSession().getAttribute("adminUser")==null){
            response1.sendRedirect("login.html");
            return;
        }
        chain.doFilter(request1,response1);
    }
}
