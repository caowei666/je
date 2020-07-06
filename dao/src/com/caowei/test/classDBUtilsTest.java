package com.caowei.test;

import com.caowei.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;

public class classDBUtilsTest {
    @Test
    public void testConnection(){
        Connection conn = DBUtils.getConnection();
        if(conn != null){
            System.out.println("连接成功");
        }
    }
}
