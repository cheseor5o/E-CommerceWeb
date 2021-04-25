package servlet;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));




        UserDAO userDAO = new UserDAOImpl();
        int flag = 0;
        try {
            flag = userDAO.registerByUsername(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == 1){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username",user.getUsername());
            String username = (String) httpSession.getAttribute("username");
            System.out.println(username);


            resp.sendRedirect("Account");

        }else {


            resp.sendRedirect("Register");
        }

    }
}
