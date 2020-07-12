package com.caowei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCookieServlet",value = "/createcookie")
public class CreateCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建cookie
        Cookie cookie = new Cookie("username", "caowei");
        //2、创建时间
        //设置有效时间
        cookie.setMaxAge(60*60*24);  //默认是-1  0 删除  60 cookie有60秒时间
        //3、设置有效路径
        cookie.setPath("/");
        //设置setHttpOnly  只有http协议可以用
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
