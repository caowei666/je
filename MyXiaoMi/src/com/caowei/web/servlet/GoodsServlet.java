package com.caowei.web.servlet;

import com.caowei.domain.Goods;
import com.caowei.domain.PageBean;
import com.caowei.service.GoodsServie;
import com.caowei.service.impl.GoodsServiceImpl;
import com.caowei.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/goods")
public class GoodsServlet extends BaseServlet {
    //带条件的分页查询
    public String getFoodsByTypeId(HttpServletRequest request, HttpServletResponse response){
        String typeid = request.getParameter("typeid");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        if(StringUtils.isEmpty(typeid)){
            return "redirect:/index.jsp";
        }
        int pageN=1;
        int pageS=8;
        if(!StringUtils.isEmpty(pageNum)){
            pageN=Integer.parseInt(pageNum);
        }
        if(!StringUtils.isEmpty(pageSize)){
            pageS=Integer.parseInt(pageSize);
        }
        String condition="typeid="+typeid;
        GoodsServie goodsServie = new GoodsServiceImpl();
        PageBean<Goods> pageBean = goodsServie.findByWhere(pageN, pageS, condition);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("typeid",typeid);
        return "goodsList.jsp";
    }
}
