package com.test.ssm.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.exam.dao.PremissionDAO;
import com.test.ssm.exam.dao.RoleDAO;
import com.test.ssm.exam.pojo.Role;
import com.test.ssm.exam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PremissionDAO premissionDAO;

    @Override
    public PageInfo getRoleList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(roleDAO.getRoleList());
    }

    @Override
    public void addRoleMenu(Integer roleId, int[] menuIds) {
        premissionDAO.deleteRoleMenuByRoleId(roleId);
        for (int menuId : menuIds) {
            premissionDAO.addRoleMenu(roleId, menuId);
        }
    }

    @Override
    public List<Integer> getMenuByRoleId(Integer roleId) {
        return premissionDAO.getMenuByRoleId(roleId);
    }

    @Override
    public List<Role> getRoleList() {
        return roleDAO.getRoleList();
    }
}
