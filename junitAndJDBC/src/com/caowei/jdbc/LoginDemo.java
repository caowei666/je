package com.caowei.jdbc;

import java.sql.*;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
        try {
            Connection coon = DriverManager.getConnection(url, "root", "19940206");
            //使用占位符查询
            PreparedStatement preparedStatement = coon.prepareStatement("select * from user where username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Statement statement = coon.createStatement();
            //ResultSet resultSet = statement.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
            //"select * from user where username='admin' or 1=1#' and password='"+password+"'"  //sql 注入
            if(resultSet.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("密码错误");
            }
            resultSet.close();
            //statement.close();
            coon.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
