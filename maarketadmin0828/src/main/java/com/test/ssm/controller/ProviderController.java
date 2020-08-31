package com.test.ssm.controller;

import com.test.ssm.pojo.AdminUser;
import com.test.ssm.pojo.Provider;
import com.test.ssm.service.ProviderService;
import com.test.ssm.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("providerList.html")
    public String list(String name, Model model){
        List<Provider> providers = providerService.getProviderList(name);
        model.addAttribute("providers",providers);
        return "providerList";
    }

    @RequestMapping("goProEdit.html")
    public String edit(Integer id,Model model){
        if(id!=null){

        }
        return "proEdit";
    }

    @RequestMapping("doProEdit.html")
    public String edit(Provider provider,Model model){
        ResultData res = null;
        if(provider.getId() == null){
            res = providerService.addProvider(provider);
        }else{
            //update
        }
        if(res.isStatus()){
            return "redirect:providerList.html";
        }
        model.addAttribute("message",res.getMessage());
        return "providerList";
    }
}
