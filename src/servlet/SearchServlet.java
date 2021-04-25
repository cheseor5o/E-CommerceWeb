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

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> productList = null;

        String search_content = req.getQueryString().replace("search=","");
        try {
            productList = productDAO.searchByKeyword(search_content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(productList);
        httpSession.setAttribute("product_list",productList);

        //req.setAttribute("product_list",productList);
        //req.getRequestDispatcher("jsp/catalogue.jsp").forward(req,resp);

        resp.sendRedirect("Catalogue");

    }
}
