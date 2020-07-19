package com.caowei.service;

import com.caowei.domain.User;

public interface UserService {
    //注册时检查用户名 看是否有重复
    public User checkUserName(String username);
    //注册
    public void regist(User user);
    //登录
    public User login(String username,String password);
}
