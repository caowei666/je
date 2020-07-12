package com.caowei.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",value = "/sessionservlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("sessionID"+session.getId()); //sessionID23F94BEAD2DE40AE751A626F819D9974
        System.out.println("sessionCreateTime"+session.getCreationTime()); //sessionCreateTime1594552103113
        System.out.println("lastAccessedTime"+session.getLastAccessedTime()); //lastAccessedTime1594552103113
        System.out.println("maxInactiveInterval"+session.getMaxInactiveInterval());//maxInactiveInterval1800   (1800秒)
        System.out.println("session 创建...");
        session.setAttribute("username","caowei");
        String username = (String)session.getAttribute("username");
        session.removeAttribute("username");   //服务器删除
        //session失效
        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
