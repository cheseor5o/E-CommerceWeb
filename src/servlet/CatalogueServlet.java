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
import java.util.List;

public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> productList = null;

        try {
            productList = productDAO.AllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpSession.setAttribute("product_list",productList);

        resp.sendRedirect("Catalogue");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> productList = null;

        try {
            productList = productDAO.AllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpSession.setAttribute("product_list",productList);

        resp.sendRedirect("Catalogue");
    }
}
