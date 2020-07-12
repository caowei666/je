package com.caowei.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApplicationServlet",value = "/applicationServlet")
public class ApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取servletContext对象
        //第一种
        ServletContext application = this.getServletContext();
        System.out.println("hashCode:"+application.hashCode()); //hashCode:1060548274
        application.setAttribute("appname","人人网");
        application.getAttribute("appname");
        application.removeAttribute("appname");
        //第二种
        ServletContext application2 = request.getServletContext();
        System.out.println("hashCode:"+application2.hashCode());//hashCode:1060548274
        //获取根路径
        String realPath = application2.getRealPath("/");
        System.out.println(realPath);  //D:\javaee\cookieAndSession\out\artifacts\cookieAndSession_war_exploded\
        //获取上下文的路径
        String contextPath = application2.getContextPath();
        System.out.println(contextPath);// /cookieAndSession(在tomcat里设置的)
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
