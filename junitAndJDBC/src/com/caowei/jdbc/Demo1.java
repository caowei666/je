package com.caowei.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1、加载（注册）驱动
        Class.forName("com.mysql.cj.jdbc.Driver");  //可以不写
        //2、创建连接
        //url:连接字符串（数据库服务器地址）
        //user:数据库的用户名
        //password:数据库的密码
        String url="jdbc:mysql://localhost:3306/wangnini?serverTimezone=GMT%2B8";
        Connection conn = DriverManager.getConnection(url, "root", "19940206");
        //3、处理
        if(conn != null){
            System.out.println("连接成功");
        }
        //4、关闭连接
        conn.close();
    }
}
