package com.test.ssm.exam.service.impl;

import com.test.ssm.exam.dao.UserDAO;
import com.test.ssm.exam.pojo.User;
import com.test.ssm.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public User doLogin(String account, String password) {
        User user = userDAO.getUserByAccount(account);
        if(user == null && !user.getPassword().equals(password)){
            return null;    //用户名或密码错误
        }
        return null;
    }
}
