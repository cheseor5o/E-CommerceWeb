package servlet;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import vo.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderTrackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        OrderDAO orderDAO = new OrderDAOImpl();
        List<OrderItem> orderItems =null;
        String order_id = req.getQueryString().replace("order_id=","");


        orderItems = (List<OrderItem>) orderDAO.selectOrderItemByOrderId(order_id);

        httpSession.setAttribute("orderItems",orderItems);
        resp.sendRedirect("OrderTrack");


    }
}
