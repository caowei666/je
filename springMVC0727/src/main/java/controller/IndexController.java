package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/a")
public class IndexController {
    @RequestMapping("index.html")
    public String index(){
        System.out.println("aaaa");
        return "/index.jsp";
    }
    @RequestMapping(value = "test.html",method = RequestMethod.POST)
    public String test(){
        System.out.println("test");
        return "/test.jsp";
    }
}
