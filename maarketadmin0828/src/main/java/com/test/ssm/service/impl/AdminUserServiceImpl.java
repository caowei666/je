package com.test.ssm.service.impl;

import com.test.ssm.dao.AdminUserMapper;
import com.test.ssm.pojo.AdminUser;
import com.test.ssm.service.AdminUserService;
import com.test.ssm.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired(required = false)
    private AdminUserMapper adminUserMapper;

    @Override
    public ResultData addUser(AdminUser adminUser) {
        AdminUser userByName = adminUserMapper.getUserByName(adminUser.getName());
        if(userByName != null){
            //用户名被占用
            return new ResultData(false,"用户名已存在");
        }
        adminUserMapper.addUser(adminUser);
        return new ResultData(true);
    }

    @Override
    public List<AdminUser> getUserList(String name) {
        return adminUserMapper.getUserList(name);
    }

    @Override
    public AdminUser getUserById(Integer id) {
        return adminUserMapper.getUserById(id);
    }

    @Override
    public void updateUser(AdminUser adminUser) {
        adminUserMapper.updateUser(adminUser);
    }

    @Override
    public AdminUser getUserByName(String name) {
        return adminUserMapper.getUserByName(name);
    }
}
