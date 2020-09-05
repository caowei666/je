package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/gologin.html")
    public String gologin(){
        return "login";
    }

    @RequestMapping("/error.html")
    public String error(){
        return "error";
    }

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    @RequestMapping("/role.html")
    public String role(){
        return "role";
    }

    @RequestMapping("/menu/user.html")
    public String user(){
        return "menu";
    }

    @RequiresPermissions("menu:edit")
    @RequestMapping("/menu/list.html")
    public String list(){
        return "menu";
    }

    @RequestMapping("/login.html")
    public String login(String username, String password, HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            req.setAttribute("error","登录失败");
            return "login";
        }
        return "redirect:/index.html";
    }
}
