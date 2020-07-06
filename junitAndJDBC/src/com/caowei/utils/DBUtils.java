package com.caowei.utils;

import java.sql.*;

public class DBUtils {
    //四个功能
    //1、注册驱动
    //2、获取连接
    //3、释放资源
    //4、执行命令（增删改，查询）
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        driver = "com.mysql.cj.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
        username="root";
        password="19940206";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    //释放资源
    public static void closeAll(Connection conn, Statement stat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //执行操作（增删改）
    public static int executeUpdate(String sql,Object ...params){
        //1、获取连接
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //设置参数
            if(params != null){
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
}
