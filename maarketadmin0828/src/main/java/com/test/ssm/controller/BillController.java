package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.Bill;
import com.test.ssm.service.BillService;
import com.test.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ProviderService providerService;

    @RequestMapping("billList")
    public String list(Bill bill, Integer pageNum, Model model){
        if(pageNum==null || pageNum<1){
            pageNum = 1;
        }
        PageInfo<Bill> pageInfo = billService.getBillList(bill,pageNum,2);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("providers",providerService.getProName());
        return "billList";
    }
}
