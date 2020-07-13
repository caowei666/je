package com.caowei.test;

import com.caowei.dao.StudentDao;
import com.caowei.dao.impl.StudentDaoImpl;
import com.caowei.domain.Student;
import org.junit.Test;

import java.util.Date;

public class StudentDaoTest {
    @Test
    public void testAdd(){
        StudentDao studentDao = new StudentDaoImpl();
        for (int i = 1; i < 100; i++) {
            studentDao.add(new Student(i,"123456","caowei"+i,"男",new Date()));
        }
        System.out.println("执行完毕");
    }
}
