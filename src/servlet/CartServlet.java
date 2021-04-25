package servlet;

import dao.CartDAO;
import dao.impl.CartDAOImpl;
import vo.CartItem;
import vo.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断是否登录
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");


        if (username == null){
            //未登录,跳转登录界面
            resp.sendRedirect("Login");
        }else {

            CartDAO cartDAO = new CartDAOImpl();
            List<CartItem> cartItems = null;
            try {
                cartItems = cartDAO.AllCartItem(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpSession.setAttribute("cartItems",cartItems);

            int total_price = 0;
            for (int i = 0;i < cartItems.size();i++){
                total_price += Integer.valueOf(cartItems.get(i).getTotal_price());
            }

            httpSession.setAttribute("total_price",total_price);

            resp.sendRedirect("Cart");

            //req.getRequestDispatcher("jsp/cart.jsp").forward(req,resp);
        }

    }

}
