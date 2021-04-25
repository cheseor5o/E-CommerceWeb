package servlet;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import vo.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        ProductDAO productDAO = new ProductDAOImpl();
        Product product = null;
        int id = Integer.parseInt(req.getQueryString());
        String product_id = req.getQueryString();
        try {
            product = productDAO.ProductDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
        }


        product.setProduct_id(product_id);

        httpSession.setAttribute("product_id",product_id);
        httpSession.setAttribute("product",product);


        resp.sendRedirect("Product");
        //req.getRequestDispatcher("jsp/product.jsp").forward(req,resp);

    }


}
