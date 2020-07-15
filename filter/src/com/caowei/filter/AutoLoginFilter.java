package com.caowei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebFilter(filterName = "AutoLoginFilter",value = "/index.jsp")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、判断当前是否已经登录
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Object username = request.getSession().getAttribute("username");
        System.out.println(username);
        if(username!=null){
            chain.doFilter(req,resp);
        }
        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!= null){
            for (Cookie c:cookies){
                if(c.getName().equals("userinfo")){
                    String base64_userinfo = c.getValue();
                    byte[] decode = Base64.getDecoder().decode(base64_userinfo);
                    String userinfo = new String(decode);
                    System.out.println(userinfo);
                    String[] split = userinfo.split("#");
                    if(split[0].equals("admin")&&split[1].equals("123")){
                        System.out.println("自动登录成功");
                        request.getSession().setAttribute("username",split[0]);
                    }else{
                        Cookie cookie2 = new Cookie("userinfo","");
                        cookie2.setMaxAge(0);
                        cookie2.setPath("/");
                        response.addCookie(cookie2);
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
