package com.caowei.test;

import com.caowei.utils.DBUtils_DBCP;
import com.caowei.utils.DBUtils_c3p0;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Test {
    @Test
    public void testConnection(){
        for (int i = 0; i < 50; i++) {
            Connection connection = DBUtils_c3p0.getConnection();
            System.out.println(i+"---"+connection.toString());
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
