package com.caowei.test;

import com.caowei.Dao.UserDao;
import com.caowei.Dao.UserDaoImpl.UserDaoImpl;
import com.caowei.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void TestFindAll(){
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        for (User u:all){
            System.out.println(u);
        }
    }
}
