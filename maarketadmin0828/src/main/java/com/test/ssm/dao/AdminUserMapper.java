package com.test.ssm.dao;

import com.test.ssm.pojo.AdminUser;

import java.util.List;

public interface AdminUserMapper {
    void addUser(AdminUser adminUser);

    List<AdminUser> getUserList(String name);

    AdminUser getUserByName(String name);

    AdminUser getUserById(Integer id);

    void updateUser(AdminUser adminUser);
}
