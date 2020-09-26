package com.test.bike.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.test.bike.pojo.PlatForm;
import com.test.bike.service.PlatformService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BikeController {
    @Reference
    private PlatformService platformService;

    @RequestMapping("list.html")
    public String list(Model model){
        List<PlatForm> platForms = platformService.getPlatformList();
        model.addAttribute("platforms",platForms);
        return "list";
    }
}
