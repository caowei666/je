package com.caowei.jdbc;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class Demo2 {
    @BeforeClass
    public static void beforeClass(){
        //1、注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //创建数据库，表
    @Test
    public void testCreateDBAndTable(){
        //2、创建连接
        String url="jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "19940206");
        //3、创建命令
            Statement stat = connection.createStatement();
        //4、执行命令  executeUpdate用于增删改
            //int result = stat.executeUpdate("create database test01");  //创建数据库
            int result = stat.executeUpdate("create table if not exists student(id int primary key,name varchar(20))");
            System.out.println(result);
        //5、关闭连接
            stat.close();
            connection.close();
            System.out.println("执行成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void testInsert(){
        //2、注册驱动
        String url="jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "19940206");
        //3、创建命令
            Statement stat = conn.createStatement();
        //4、执行命令
            int i = stat.executeUpdate("insert into student values(12,'艾克')");
            i = stat.executeUpdate("insert into student values(13,'梦多')");
            System.out.println(i);
        //5、关闭
            stat.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void testQuery(){
        //2、创建连接
        String url = "jdbc:mysql://localhost:3306/test01?serverTimezone=GMT%2B8";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "19940206");
            //3、创建命令
            Statement statement = connection.createStatement();
            //4、执行命令
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id+"--"+name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
