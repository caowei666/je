package com.caowei.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "ImgServlet",value = "/imgservlet")
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回图片
        //        response.setContentType("image/jpeg");
        //下载
        //response.setHeader("content-disposition","attachment;filename=11.jpg");
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("图片.jpg","utf-8"));
        //返回图片
        //读取图片路径
        String imgpath = request.getServletContext().getRealPath("/cat.jpg");
        //1、用IO流读取图片
        //2、创建流
        FileInputStream fis = new FileInputStream(imgpath);
        byte[] buf = new byte[1024];
        int len = 0;
        ServletOutputStream os = response.getOutputStream();
        while ((len = fis.read(buf)) != -1){
            os.write(buf,0,len);
        }
        //3、关闭
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
