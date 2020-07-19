package com.caowei.service.impl;

import com.caowei.dao.UserDao;
import com.caowei.dao.impl.UserDaoImpl;
import com.caowei.domain.User;
import com.caowei.service.UserService;
import com.caowei.utils.Md5Utils;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUserName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void regist(User user) {
        //逻辑
        //1、密码加密 2、发送邮件
        user.setPassword(Md5Utils.md5(user.getPassword()));
        userDao.add(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }
}
