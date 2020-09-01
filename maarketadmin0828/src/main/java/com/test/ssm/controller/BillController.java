package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.AdminUser;
import com.test.ssm.pojo.Bill;
import com.test.ssm.service.BillService;
import com.test.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ProviderService providerService;

    @RequestMapping("billList.html")
    public String list(Bill bill, Integer pageNum, Model model, HttpSession session){
        if(pageNum==null || pageNum<1){
            pageNum = 1;
        }
        AdminUser session_user = (AdminUser)session.getAttribute("adminUser");
        bill.setCreatedPerson(String.valueOf(session_user.getId()));
        PageInfo<Bill> pageInfo = billService.getBillList(bill,pageNum,2);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("providers",providerService.getProName());
        return "billList";
    }

    @RequestMapping("goBillEdit.html")
    public String goEdit(Integer id, Model model) {
        model.addAttribute("providers", providerService.getProName());
        if (id != null) {
            Bill bill = billService.getBillById(id);
            model.addAttribute("bill", bill);
        }
        return "billEdit";
    }

    @RequestMapping("doEditBill.html")
    public String doEdit(Bill bill){
        if(bill.getId()!=null){
            bill.setCreatedDate(new Date());
            billService.update(bill);
        }else{
            bill.setCreatedDate(new Date());
            billService.insert(bill);
        }
        return "redirect:billList.html";
    }

    @RequestMapping("billView.html")
    public String goView(Integer id, Model model){
        model.addAttribute("billItem",billService.getBillById(id));
        return "billView.html";
    }

    @RequestMapping("delBill.html")
    public String goView(Integer id){
        billService.deleteById(id);
        return "redirect:billList.html";
    }
}
