package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Commodity", urlPatterns = "/commodity")
public class CommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommodityDao commodityDao = new CommodityDao();
        req.setAttribute("data", commodityDao.findAll());
        req.getRequestDispatcher("/jsp/show.jsp").forward(req,resp);
    }
}
