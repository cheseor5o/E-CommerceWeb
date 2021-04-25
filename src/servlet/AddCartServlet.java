package servlet;

import dao.CartDAO;
import dao.impl.CartDAOImpl;
import vo.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断是否登录
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");
        httpSession.setAttribute("product_id",req.getParameter("product_id"));


        if (username == null){
            //未登录,跳转登录界面
            resp.sendRedirect("Login");
        }else {
            //此处要判断购物车里是否有某id的商品
            //如果有 加数量
            //如果无 加新车
            String product_id = (String) httpSession.getAttribute("product_id");
            Integer product_num = Integer.valueOf(req.getParameter("product_num"));



            CartDAO cartDAO = new CartDAOImpl();
            List<CartItem> cartItems = null;
            try {
                cartItems = cartDAO.AllCartItem(username);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int flag = 0;
            int product_onum = 0;
            int base_price = 0 ;
            String cart_item_id = null;
            for (int i = 0; i < cartItems.size();i++){
                if (cartItems.get(i).getProduct_id().equals(product_id)){
                    flag = 1;
                    product_onum = Integer.valueOf(cartItems.get(i).getNum());
                    cart_item_id = String.valueOf(cartItems.get(i).getCart_item_id());
                    base_price = Integer.valueOf(cartItems.get(i).getBase_price());
                    break;
                }
            }

            if (flag == 0){
                try {
                    if (product_id == null){
                        req.getRequestDispatcher("CartServlet").forward(req,resp);
                    }else {
                    cartDAO.addToCart(username,product_id,product_num);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                int product_total_num = product_onum + product_num;
                try {
                    cartDAO.addNumCart(base_price,cart_item_id,product_total_num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            httpSession.setAttribute("product_id",null);
            req.getRequestDispatcher("CartServlet").forward(req,resp);


        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //判断是否登录
//        HttpSession httpSession = req.getSession();
//        String username = (String) httpSession.getAttribute("username");
//
//
//        if (username == null) {
//            //未登录,跳转登录界面
//            resp.sendRedirect("jsp/login.jsp");
//        } else {
//            //此处要判断购物车里是否有某id的商品
//            //如果有 加数量
//            //如果无 加新车
//            String product_id = (String) httpSession.getAttribute("product_id");
//            Integer product_num = Integer.valueOf(req.getParameter("product_num"));
//
//            CartDAO cartDAO = new CartDAOImpl();
//            List<CartItem> cartItems = null;
//            try {
//                cartItems = cartDAO.AllCartItem(username);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            int flag = 0;
//            int product_onum = 0;
//            int base_price = 0;
//            String cart_item_id = null;
//            for (int i = 0; i < cartItems.size(); i++) {
//                if (cartItems.get(i).getProduct_id().equals(product_id)) {
//                    flag = 1;
//                    product_onum = Integer.valueOf(cartItems.get(i).getNum());
//                    cart_item_id = String.valueOf(cartItems.get(i).getCart_item_id());
//                    base_price = Integer.valueOf(cartItems.get(i).getBase_price());
//                    break;
//                }
//            }
//
//            if (flag == 0) {
//                try {
//                    if (product_id == null) {
//                        req.getRequestDispatcher("CartServlet").forward(req, resp);
//                    } else {
//                        cartDAO.addToCart(username, product_id, product_num);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                int product_total_num = product_onum + product_num;
//                try {
//                    cartDAO.addNumCart(base_price, cart_item_id, product_total_num);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            httpSession.setAttribute("product_id", null);
//
//
//            req.getRequestDispatcher("CartServlet").forward(req, resp);
//
//        }
//    }
}
