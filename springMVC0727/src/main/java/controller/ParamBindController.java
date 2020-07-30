package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Dept;
import pojo.Employee;

import java.util.Arrays;

@Controller
public class ParamBindController {
    @RequestMapping("p1.html")
//    参数required默认是true
    public String test(@RequestParam(name="num",required = false,defaultValue = "1") Integer num){
        System.out.println(num);
        return "/test.jsp";
    }
    @RequestMapping("add.html")
    public String add(Dept dept){
        System.out.println(dept);
        return "test.jsp";
    }
    @RequestMapping("addEmp.html")
    public String add(Employee emp){
        System.out.println(emp);
        return "test.jsp";
    }
    @RequestMapping("param6.html")
    public String param6(int[] answer){
        System.out.println(Arrays.toString(answer));
        return "test.jsp";
    }
}
