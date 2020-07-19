package com.caowei.web.filter;

import com.caowei.domain.User;
import com.caowei.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "AutoFilter",value = "/myxiaomi/index.jsp")
public class AutoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //实现自动登录功能
        //1、判断是否已经登录
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User)request.getSession().getAttribute("user");
        if(user!=null){
            chain.doFilter(req,resp);
        }
        //2、获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("userinfo")){
                    String userinfo = cookie.getValue();
                    String[] userinfos = userinfo.split("#");
                    UserServiceImpl userService = new UserServiceImpl();
                    System.out.println(userinfos[0]);
                    System.out.println(userinfos[1]);
                    User user2 = userService.login(userinfos[0], userinfos[1]);
                    if(user2!=null){
                        request.getSession().setAttribute("user",user2);
                        System.out.println("自动登录成功");
                    }else{
                        Cookie cookie2 = new Cookie("userinfo", userinfo);
                        cookie2.setMaxAge(0);
                        cookie2.setPath("/");
                        cookie2.setHttpOnly(true);
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
