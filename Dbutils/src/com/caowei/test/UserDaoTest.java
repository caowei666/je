package com.caowei.test;

import com.caowei.dao.UserDao;
import com.caowei.dao.UserDaoImpl.UserDaoImpl;
import com.caowei.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void testFindAll(){
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        for (User u:all){
            System.out.println(u);
        }
    }
    @Test
    public void testFindById(){
        UserDao userDao = new UserDaoImpl();
        User byid = userDao.findByid(3);
        System.out.println(byid);
    }
    @Test
    public void testAdd(){
        UserDao userDao = new UserDaoImpl();
        User user = new User(4,"nihao","123","nihao@qq.com");
        userDao.add(user);
    }
    @Test
    public void testUpdate(){
        UserDao userDao = new UserDaoImpl();
        User user = new User(4,"hao","333","nihao@qq.com");
        userDao.update(user);
    }
    @Test
    public void testDelete(){
        UserDao userDao = new UserDaoImpl();
        int id = 4;
        userDao.delete(id);
    }
}
