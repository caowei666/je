package com.test.boot.service;

import com.github.pagehelper.PageInfo;
import com.test.boot.pojo.User;
import com.test.boot.util.AjaxResult;

import java.util.List;

public interface UserService {
    //User doLogin(String account, String password);

    PageInfo<User> getUserList(User user, int pageNum, int pageSize);

    AjaxResult addUser(User user);

    AjaxResult updateUser(User user);

    AjaxResult deleteUser(int[] ids);

    void addUserRole(Integer userId,int[] roleIds);

    List<Integer> getUserRole(Integer userId);
}
