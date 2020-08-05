package controller;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pojo.Dept;

import javax.security.auth.login.Configuration;
import java.util.Map;

@Controller
public class ViewController {
//    @Autowired
//    private FreeMarkerConfigurer freeMarkerConfigurer;
//    @RequestMapping("free.html")
//    public String freemarker(){
//        Configuration configuration = freeMarkerConfigurer.getConfiguration();
//        Template template = configuration.getTemplate("fm.ftl");
//    }
    @RequestMapping("hello.html")
    public String hello(){
        return "helloView";   //配置里面bean的id
    }

    @RequestMapping("body")
    @ResponseBody
    public Dept body(){
        Dept dept = new Dept();
        dept.setId(456);
        dept.setName("name");
        return dept;
    }
}
