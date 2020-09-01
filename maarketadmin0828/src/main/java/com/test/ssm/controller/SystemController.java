package com.test.ssm.controller;

import com.test.ssm.pojo.AdminUser;
import com.test.ssm.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SystemController {
    @Autowired
    private AdminUserService adminUserService;


    @RequestMapping("/")
    public String view(){
        return "login";
    }

    @RequestMapping("{page}.html")
    public String index(@PathVariable String page,HttpSession httpSession){
        System.out.println(httpSession.getAttribute("adminUser"));
        return page;
    }
    @RequestMapping("doLogin.html")
    public String login(String name, String password, Model model, HttpSession httpSession){
        AdminUser userByName = adminUserService.getUserByName(name);
        if(userByName==null || !userByName.getPassword().equals(password)){
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
        httpSession.setAttribute("adminUser",userByName);
        return "redirect:index.html";
    }

    @RequestMapping("doLoginOut.html")
    public String louOut(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }
}
