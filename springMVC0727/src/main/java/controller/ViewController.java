package controller;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.security.auth.login.Configuration;

@Controller
public class ViewController {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @RequestMapping("free.html")
    public String freemarker(){
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = configuration.getTemplate("fm.ftl");
    }
}
