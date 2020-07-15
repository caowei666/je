package com.caowei.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "LoginServlet",value = "/loginservlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");
        if(username.equals("admin")&&password.equals("123")){
            System.out.println("登录成功");
            request.getSession().setAttribute("username",username);
            //判断是否自动登录
            if(auto!=null){
                String userinfo = username+"#"+password;
                String base64_userinfo = Base64.getEncoder().encodeToString(userinfo.getBytes());
                Cookie cookie = new Cookie("userinfo",base64_userinfo);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                System.out.println("自动登录cookie创建了");
            }
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
