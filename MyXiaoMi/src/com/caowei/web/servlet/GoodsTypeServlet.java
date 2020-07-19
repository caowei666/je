package com.caowei.web.servlet;

import com.alibaba.druid.support.json.JSONUtils;
import com.caowei.dao.GoodsTypeDao;
import com.caowei.domain.GoodsType;
import com.caowei.service.GoodsTypeService;
import com.caowei.service.impl.GoodsTypeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request, HttpServletResponse response) throws Exception{
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
//        response.setContentType("application/json;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<GoodsType> goodTypeList = goodsTypeService.getGoodsTypeByLevel(1);
        if(goodTypeList!=null){
//            String json = JSONUtils.toJSONString(goodTypeList);
//            response.getWriter().write(json);
            request.setAttribute("goodsTypeList",goodTypeList);
//            System.out.println(Arrays.toString(goodTypeList.toArray()));
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        return null;
    }
}
