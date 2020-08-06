package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("login.html")
    public String login(String username, String password, HttpSession session){
        if("admin".equals(username) && "admin".equals(password)){
            session.setAttribute("session_user",username);
            return "index";
        }
        return "login";
    }
    @RequestMapping("index.html")
    public String index(){
        return "index";
    }
}
