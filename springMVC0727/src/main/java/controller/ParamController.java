package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("param.html")
public class ParamController {
    @RequestMapping(params = "act=1")
    public String m1(){
        System.out.println("方法1");
        return "/test.jsp";
    }

    @RequestMapping(params = "act=2")
    public String m2(){
        System.out.println("方法2");
        return "/test.jsp";
    }
}
