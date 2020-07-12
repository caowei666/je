package com.caowei.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1",value="/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收浏览器请求
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println("浏览器发送"+username);
        //重定向
//        response.sendRedirect("servlet2");
//        response.sendRedirect("https://www.baidu.com");
        //转发
//        RequestDispatcher rs = request.getRequestDispatcher("/servlet2");
//        rs.forward(request,response);
         request.getRequestDispatcher("/servlet2").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
