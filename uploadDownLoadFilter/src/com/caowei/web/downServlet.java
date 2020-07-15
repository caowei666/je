package com.caowei.web;

import com.caowei.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "downServlet",value = "/down")
public class downServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uuidfilename = request.getParameter("filename");
        String basePath = this.getServletContext().getRealPath("WEB-INF/upload");
        if(uuidfilename!=null&&uuidfilename.trim().length()!=0){
            String filename = uuidfilename.substring(uuidfilename.indexOf("_") + 1);
            String newPath = UploadUtils.createNewPath(basePath, filename);
            File file = new File(newPath+"/"+uuidfilename);
            if(file.exists()){
                response.setHeader("content-disposition","attachmen;filename="+ URLEncoder.encode(filename,"utf-8"));
                FileInputStream fileInputStream = new FileInputStream(file);
                ServletOutputStream os = response.getOutputStream();
                byte[] buf = new byte[1024*4];
                int len = -1;
                while ((len=fileInputStream.read(buf))!=-1){
                    os.write(buf,0,len);
                }
            }else{
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("文件已删除");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
