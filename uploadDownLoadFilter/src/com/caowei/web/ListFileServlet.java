package com.caowei.web;

import com.caowei.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ListFileServlet",value = "/listfile")
public class ListFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //遍历文件夹（把要下载的文件名放入要下载的hashMap集合）
        Map<String,String> hashMap = new HashMap<>();
        String basePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        UploadUtils.listFiles(new File(basePath),hashMap);
        request.setAttribute("maps",hashMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
