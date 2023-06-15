package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add")
public class AddCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        BigDecimal b = null;
        try{
            b = new BigDecimal(price);
        }catch (Exception e){
            req.setAttribute("error","添加失败，价格必须是数字");
            req.getRequestDispatcher("/jsp/add.jsp").forward(req,resp);
            return;
        }
        String describe = req.getParameter("describe");
        Commodity commodity = new Commodity(name, b,describe);
        CommodityDao commodityDao = new CommodityDao();
        commodityDao.add(commodity);
        resp.sendRedirect("/commodity");
    }
}
