package controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmpController {
//    @InitBinder    //对当前controller所有方法日期格式生效
//    public void initBinder(ServletRequestDataBinder binder){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,true));
//    }
    @RequestMapping("date.html")
    public String date(Date d, @CookieValue("JSESSIONID")String id){
        System.out.println(id);
        System.out.println(d);
        return "emp";
    }
    @RequestMapping("emp.html")
    public String addEmp(@Validated Employee employee, BindingResult result, Model model){
//        if(result.hasErrors()){
//            FieldError name = result.getFieldError("name");
//            FieldError salary = result.getFieldError("salary");
//            if(name != null){
//                model.addAttribute("nameError",name.getDefaultMessage());
//            }
//            if(salary!=null){
//                model.addAttribute("salaryError",salary.getDefaultMessage());
//            }
//        }
        System.out.println(employee);
        return "emp";
    }
}
