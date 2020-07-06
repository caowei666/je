package com.caowei.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
//        driver = "com.mysql.cj.jdbc.Driver";
//        url="jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
//        username="root";
//        password="19940206";
        Properties properties = new Properties();
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");

        //1、注册驱动
        try {
            //Class.forName(driver);
            properties.load(inputStream);
            driver= properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册驱动失败");
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static void closeAll(Connection conn, Statement stat, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(stat != null){
                stat.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static int executeUpdate(String sql,Object...params){
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn=getConnection();
            pstat = conn.prepareStatement(sql);
            if(params != null){
                for (int i = 0; i < params.length; i++) {
                    pstat.setObject(i+1,params[i]);
                }
            }
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
