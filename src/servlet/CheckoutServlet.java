package servlet;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import vo.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        //CartItem cartItems = (CartItem) httpSession.getAttribute("cartItems");
        List<CartItem> cartItems = (List<CartItem>) httpSession.getAttribute("cartItems");
        String username = (String) httpSession.getAttribute("username");

        OrderDAO orderDAO = new OrderDAOImpl();


        if (cartItems == null){
            resp.sendRedirect("CatalogueServlet");
        }else {
            if (cartItems.size() > 0) {
                orderDAO.createOrder((List<CartItem>) cartItems, username);
                httpSession.setAttribute("cartItems", null);
                httpSession.setAttribute("total_price", 0);
                resp.sendRedirect("OrderServlet");
            } else {
                resp.sendRedirect("CatalogueServlet");
            }
        }


    }


}
