package com.test.ssm.service;

import com.test.ssm.pojo.AdminUser;
import com.test.ssm.util.ResultData;

import java.util.List;

public interface AdminUserService {
    ResultData addUser(AdminUser adminUser);

    List<AdminUser> getUserList(String name);

    AdminUser getUserById(Integer id);

    void updateUser(AdminUser adminUser);

    AdminUser getUserByName(String name);
}
