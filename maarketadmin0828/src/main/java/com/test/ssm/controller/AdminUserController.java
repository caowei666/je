package com.test.ssm.controller;

import com.test.ssm.pojo.AdminUser;
import com.test.ssm.service.AdminUserService;
import com.test.ssm.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("userList.html")
    public String list(String name, Model model){
        List<AdminUser> adminUsers = adminUserService.getUserList(name);
        model.addAttribute("adminUsers",adminUsers);
        return "userList";
    }

    @RequestMapping("doUserEdit.html")
    public String edit(AdminUser adminUser,Model model){
        ResultData res = adminUserService.addUser(adminUser);
        if(res.isStatus()){
            return "redirect:userList.html";
        }
        model.addAttribute("message",res.getMessage());
        return "userEdit";
    }

    @RequestMapping("goUserEdit.html")
    public String edit(Integer id,Model model){
        if(id!=null){
            AdminUser userById = adminUserService.getUserById(id);
            model.addAttribute("adminUser",userById);
        }
        return "userEdit";
    }
}
