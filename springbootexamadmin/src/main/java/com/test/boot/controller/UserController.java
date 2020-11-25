package com.test.boot.controller;

import com.github.pagehelper.PageInfo;
import com.test.boot.pojo.Role;
import com.test.boot.pojo.User;
import com.test.boot.service.RoleService;
import com.test.boot.service.UserService;
import com.test.boot.util.AjaxResult;
import com.test.boot.util.TableData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/user.html")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String page(){
        return "user";
    }
    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(User user, Integer page, Integer limit){
        PageInfo<User> pageInfo = userService.getUserList(user,page,limit);
        return new TableData(pageInfo.getTotal(),pageInfo.getList());
    }

    @RequiresPermissions("sys:user:add")
    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxResult edit(User user){
        if(user.getId()==null){
            return userService.addUser(user);
        }
        return userService.updateUser(user);
    }

    @RequestMapping(params = "act=delete")
    @ResponseBody
    public AjaxResult delete(int[] ids){
        try {
            return userService.deleteUser(ids);
        } catch (Exception e) {
            e.printStackTrace();
            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setStatus(false);
            ajaxResult.setMessage(e.getMessage());
            return ajaxResult;
        }
    }

    @RequestMapping(params = "act=roles")
    @ResponseBody
    public List<Role> roleList(){
        return roleService.getRoleList();
    }

    @RequestMapping(params = "act=assign")
    @ResponseBody
    public AjaxResult tree(Integer userId, int[] roleIds) {
        AjaxResult res = new AjaxResult();
        try {
            userService.addUserRole(userId,roleIds);
            res.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @RequestMapping(params = "act=user_role")
    @ResponseBody
    public List<Integer> userRole(Integer userId){
        return userService.getUserRole(userId);
    }
}
