package com.test.ssm.exam.service;

import com.test.ssm.exam.pojo.User;

public interface UserService {
    User doLogin(String account,String password);
}
