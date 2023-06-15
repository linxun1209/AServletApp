package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author xing'chen
 */
@WebServlet(name = "delete",urlPatterns = "/delete")
public class DeleteCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        CommodityDao commodityDao = new CommodityDao();
        commodityDao.delete(id);
        resp.sendRedirect("/commodity");
    }
}
