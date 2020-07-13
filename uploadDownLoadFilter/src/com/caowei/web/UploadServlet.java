package com.caowei.web;

import com.caowei.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "UploadServlet",value = "/uploadservlet")
@MultipartConfig(maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*20)
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        //1、获取request表单中的部分,parts表示表单中一部分内容
        Collection<Part> parts = request.getParts();
        String basePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        //2、变量
        if(parts!=null){
            for (Part part:parts){
                //判断是文件项还是普通项
                String submittedFileName = part.getSubmittedFileName();
                if(submittedFileName==null){
                    //获取用户名
                    String name = part.getName();
                    String value = request.getParameter(name);
                    System.out.println(name+":"+value);
                }else {
                    System.out.println("文件名："+submittedFileName);
                    if(submittedFileName==""){
                        continue;
                    }
                    String newFileName = UploadUtils.createNewFileName(submittedFileName);
                    String newPath = UploadUtils.createNewPath(basePath, submittedFileName);
                    part.write(newPath+"/"+newFileName); //后上传的会覆盖前上传的同名文件
                    //清理缓存文件
                    part.delete();
                    //响应内容
                    out.write("<h3>上传成功：</h3>"+submittedFileName+"<br/>");
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
