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
import java.sql.SQLException;
import java.util.List;

public class OrderRefundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        List<Order> orders = (List<Order>) httpSession.getAttribute("orders");
        OrderDAO orderDAO = new OrderDAOImpl();
        String order_id = req.getQueryString().replace("order_id=","");

        String status = null;
        for (int i = 0;i<orders.size();i++){
            if (orders.get(i).getOrder_id().equals(order_id)){
                status = orders.get(i).getStatus();
                break;
            }else {
                continue;
            }
        }

        if (status.equals("Paid")) {
            try {
                orderDAO.refundByOrderId(order_id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resp.sendRedirect("OrderServlet");
        }else {
            resp.sendRedirect("OrderServlet");
        }

    }
}
