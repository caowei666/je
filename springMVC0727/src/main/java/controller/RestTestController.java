package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestTestController {
    @RequestMapping("/page/{a}")
    public String page(@PathVariable(name = "a") String name){
        return "/"+name+".jsp";
    }
    @RequestMapping("res/{param:[\\d]+.html}")
    public String param(@PathVariable String param){
        System.out.println(param);   //1.html
        return "/test.jsp";
    }
}
