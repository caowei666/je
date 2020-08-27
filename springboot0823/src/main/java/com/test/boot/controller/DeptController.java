package com.test.boot.controller;

import com.test.boot.pojo.Dept;
import com.test.boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("list.html")
    public String list(Model model){
        List<Dept> deptList = deptService.getDeptList();
        model.addAttribute("list",deptList);
        model.addAttribute("num",1);
        model.addAttribute("today",new Date());
        model.addAttribute("message","<h1>hello thyleaf</h1>");
        return "list";
    }

    @RequestMapping("add.html")
    public String add(Dept dept){
        deptService.addDept(dept);
        return "redirect:list.html";
    }
}
