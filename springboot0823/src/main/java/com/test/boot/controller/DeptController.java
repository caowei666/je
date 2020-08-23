package com.test.boot.controller;

import com.test.boot.pojo.Dept;
import com.test.boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("list.html")
    public String list(Model model){
        List<Dept> deptList = deptService.getDeptList();
        model.addAttribute("list",deptList);
        return "list.jsp";
    }
}
