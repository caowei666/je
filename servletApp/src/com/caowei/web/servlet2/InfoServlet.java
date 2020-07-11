package com.caowei.web.servlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet",value = "/infoservlet")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收浏览器的数据
        //浏览器发送的数据是中文，tomcat里面采用的是iso8859-1
        request.setCharacterEncoding("utf-8");  //这样就可以接收中文了
        response.setContentType("text/html;charset=utf-8");//设置响应数据格式是utf-8
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println(username+age);
        PrintWriter writer = response.getWriter();
        writer.write("<h3>添加成功</h3>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
