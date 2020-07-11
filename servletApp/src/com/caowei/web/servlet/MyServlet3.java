package com.caowei.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/myservlet3",loadOnStartup = 0)
public class MyServlet3 implements Servlet {
    //初始化servlet方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init初始化....");
    }
    //获取servlet配置
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig执行了....");
        return null;
    }
    //服务方法：执行处理浏览器请求的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service执行了....");
    }
    //获取servlet信息，作者版权
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo执行了....");
        return null;
    }
    //销毁servlet
    @Override
    public void destroy() {
        System.out.println("destroy执行了....");
    }
}
