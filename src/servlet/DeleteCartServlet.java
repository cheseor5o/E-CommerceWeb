package servlet;

import dao.CartDAO;
import dao.impl.CartDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Writer out;
        PrintWriter printWriter = resp.getWriter();

        CartDAO cartDAO = new CartDAOImpl();
        String cart_item_id = req.getQueryString().replace("cart_item_id=","");

        try {
            cartDAO.deleteCart(cart_item_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("CartServlet");

    }
}
