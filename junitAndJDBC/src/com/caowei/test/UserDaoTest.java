package com.caowei.test;

import com.caowei.dao.UserDao;
import com.caowei.dao.impl.UserDaoImpl;
import com.caowei.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testAdd(){
        User user = new User(0,"二狗","123","ergou@qq.com");
        UserDao ud = new UserDaoImpl();
        ud.add(user);
    }
    @Test
    public void testUpdate(){
        User user = new User(4,"ergou","123","ergou@qq.com");
        UserDao ud = new UserDaoImpl();
        ud.update(user);
    }
    @Test
    public void testDelete(){
        int id = 4;
        UserDao ud = new UserDaoImpl();
        ud.delete(id);
    }
}
