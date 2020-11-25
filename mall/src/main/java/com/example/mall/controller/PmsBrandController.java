package com.example.mall.controller;


import com.example.mall.pojo.PmsBrand;
import com.example.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PmsBrandController {
    @Autowired(required = false)
    private PmsBrandService pmsBrandService;

    @RequestMapping("/getBrandList")
    @ResponseBody
    public List<PmsBrand> getBrandList(){
        return pmsBrandService.listAllBrand();
    }
}
