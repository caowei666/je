package com.test.ssm.exam.controller;


import com.github.pagehelper.PageInfo;
import com.test.ssm.exam.pojo.Menu;
import com.test.ssm.exam.pojo.Role;
import com.test.ssm.exam.service.RoleService;
import com.test.ssm.exam.util.AjaxResult;
import com.test.ssm.exam.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/role.html")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String page() {
        return "role";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData<Role> table(Integer page, Integer limit) {
        PageInfo<Role> roleList = roleService.getRoleList(page, limit);
        return new TableData<>(roleList.getTotal(),roleList.getList());
    }


    @RequestMapping(params = "act=assign")
    @ResponseBody
    public AjaxResult tree(Integer roleId,int[] menuIds) {
        AjaxResult res = new AjaxResult();
        try {
            roleService.addRoleMenu(roleId,menuIds);
            res.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @RequestMapping(params = "act=menu")
    @ResponseBody
    public List<Integer> menus(Integer roleId){
        return roleService.getMenuByRoleId(roleId);
    }
}
