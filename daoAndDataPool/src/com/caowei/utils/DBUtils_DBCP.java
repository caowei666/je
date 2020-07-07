package com.caowei.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils_DBCP {
    //1、创建连接池对象
    private static BasicDataSource dataSource;
    static{
        Properties properties = new Properties();
        InputStream is = DBUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            properties.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建连接池失败");
        }
    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
