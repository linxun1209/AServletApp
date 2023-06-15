package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


@WebServlet(name = "update", urlPatterns = "/update")
public class UpdateCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        CommodityDao commodityDao = new CommodityDao();
        Commodity commodity = commodityDao.findByid(id);
        req.setAttribute("commodity",commodity);
        req.getRequestDispatcher("/jsp/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String describe = req.getParameter("describe");
        BigDecimal b = null;
        try{
            b = new BigDecimal(price);
        }catch (Exception e){
            Commodity commodity = new Commodity(Long.parseLong(id),name,null,describe);
            req.setAttribute("commodity",commodity);
            req.setAttribute("error","修改失败，价格必须是数字");
            req.getRequestDispatcher("/jsp/update.jsp").forward(req,resp);
            return;
        }
        Commodity commodity = new Commodity(Long.parseLong(id),name,b,describe);
        CommodityDao commodityDao = new CommodityDao();
        commodityDao.update(commodity);
        resp.sendRedirect("/commodity");
    }
}
