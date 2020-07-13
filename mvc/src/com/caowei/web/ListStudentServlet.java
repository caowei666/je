package com.caowei.web;

import com.caowei.domain.PageBean;
import com.caowei.domain.Student;
import com.caowei.service.StudentService;
import com.caowei.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListStudentServlet",value = "/liststudentservlet")
public class ListStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        int pageN = 0;
        int pageS = 0;
        if(pageNum == null || pageNum.trim().length()==0){
            pageN=1;
        }else {
            pageN = Integer.parseInt(pageNum);
        }
        if(pageSize == null || pageSize.trim().length()==0){
            pageS=10;
        }else {
            pageS = Integer.parseInt(pageSize);
        }
        StudentService studentService = new StudentServiceImpl();
        PageBean<Student> pageBean = studentService.findByPage(pageN,pageS);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/stu.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
