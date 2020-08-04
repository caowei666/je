package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pojo.Dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@SessionAttributes(value = {"key1"})
public class ModalController {
    @RequestMapping("test1.html")
    public String test1(Map map){
        map.put("key1",123);
        map.put("key2","abc");
        return "modal";
    }
    @RequestMapping("test2.html")
    public String test2(Model model){
        model.addAttribute("key1",456);
        model.addAttribute("key2","caowei");
        return "modal";
    }
    @RequestMapping("test3.html")
    public ModelAndView test3(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key1",789);
        modelAndView.addObject("key2","qwe");
        modelAndView.setViewName("modal.jsp");
        return modelAndView;
    }
    @RequestMapping("test4.html")
    public String test4(@ModelAttribute String name,@ModelAttribute Dept dept){
        System.out.println(name);
        System.out.println("dept.name="+dept.getName());
        name="aaa";
        dept = new Dept();
        dept.setName("ddd");
        return "modal";
    }
    @ModelAttribute("dept")
    public Dept getDept(){
        System.out.println("=================");
        Dept dept = new Dept();
        dept.setId(123);
        dept.setName("qwe");
        return dept;
    }
    @RequestMapping("test5.html")
    public String test5(@ModelAttribute Dept dept){
        System.out.println(dept.getId());
        System.out.println(dept.getName());
        return "modal";
    }
    @RequestMapping("test6.html")
    public String test6(HttpServletRequest request){
        request.setAttribute("key1","000");
        return "modal";
    }
}
