package servlet;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import vo.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否登录
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");

        if (username == null){
            //未登录,跳转登录界面
            resp.sendRedirect("Login");
        }else {

            OrderDAO orderDAO = new OrderDAOImpl();
            List<Order> orders = null;

            orders = orderDAO.selectOrderByUsername(username);
            httpSession.setAttribute("orders",orders);

            resp.sendRedirect("Order");

        }
    }
}
