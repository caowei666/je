package com.test.ssm.exam.controller;

import com.test.ssm.exam.pojo.Menu;
import com.test.ssm.exam.pojo.User;
import com.test.ssm.exam.service.MenuService;
import com.test.ssm.exam.service.UserService;
import com.test.ssm.exam.util.ExamConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("index.html")
    public String index(Model model){
        List<Menu> menuTree = menuService.getMenuTree(false);
        model.addAttribute("menuList",menuTree);
        System.out.println(menuTree);
        return "index";
    }

    @RequestMapping("dologin.html")
    public String login(String account, String password, Model model, HttpSession session){
        User user = userService.doLogin(account, password);
        if(user == null){
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
        session.setAttribute(ExamConstants.SESSIONUSER,user);
        System.out.println(user);
        return "redirect:index.html";
    }
    @RequestMapping("logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
