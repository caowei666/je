package com.test.boot.controller;

import com.test.boot.pojo.Menu;
import com.test.boot.pojo.User;
import com.test.boot.service.MenuService;
import com.test.boot.service.UserService;
import com.test.boot.util.ExamConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemController {
    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String hello(){
        return "forward:login.html";
    }

    @RequestMapping("error.html")
    public String error(){
        return "error";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("index.html")
    public String index(Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
//        User user = (User)session.getAttribute(ExamConstants.SESSIONUSER);
        List<Menu> menuTree = menuService.getUserMenuList((int)subject.getPrincipal());
        model.addAttribute("menuList",menuTree);
        System.out.println(menuTree);
        session.setAttribute(ExamConstants.USER_MENU,menuTree);
        return "index";
    }

    @RequestMapping("dologin.html")
    public String login(String account, String password, Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, DigestUtils.md5DigestAsHex((password+ ExamConstants.PASSWORD_SALT).getBytes()));
        //User user = userService.doLogin(account, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("message","用户名或密码错误");
            return "login";

        }
//        if(user == null){
//            model.addAttribute("message","用户名或密码错误");
//            return "login";
//        }
//        session.setAttribute(ExamConstants.SESSIONUSER,user);   //用户存到subject中了
//        System.out.println(user);
        return "redirect:index.html";
    }
    @RequestMapping("logout.html")
    public String logout(){
//        session.invalidate();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
