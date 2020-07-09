package com.caowei.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//value:servlet访问的地址
//urlPatterns：也是servlet访问路径（必须加key）
//name:给servlet起个名字
//loadOnStartup:启动时时候加载，默认是-1，第一次访问实例化
//      如果>=0，启动时实例化数字越小优先级越高
@WebServlet(value = "/myservlet1",urlPatterns = )
public class MyServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("hello servlet");
        //以前我们用IO，我们用流  getOutPutStream
        PrintWriter out = resp.getWriter();
        out.write("hello servlet!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
