package com.test.boot.service;

import com.github.pagehelper.PageInfo;
import com.test.boot.pojo.Role;

import java.util.List;

public interface RoleService {
    PageInfo getRoleList(int pageNum, int pageSize);
    void addRoleMenu(Integer roleId,int[] menuIds);

    List<Integer> getMenuByRoleId(Integer roleId);

    List<Role> getRoleList();
}