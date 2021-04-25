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

public class ModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String username = (String) session.getAttribute("username");


        User user = new User();
        user.setUsername((String) session.getAttribute("username"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setGender(req.getParameter("gender"));
        user.setBirthday(req.getParameter("birthday"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setAddress(req.getParameter("address"));

        UserDAO userDAO = new UserDAOImpl();
        int flag = 0;
        try {
            flag = userDAO.modifyByUsername(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag == 1){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("password",user.getPassword());
            httpSession.setAttribute("name",user.getName());
            httpSession.setAttribute("gender",user.getGender());
            httpSession.setAttribute("birthday",user.getBirthday());
            httpSession.setAttribute("phone",user.getPhone());
            httpSession.setAttribute("email",user.getEmail());
            httpSession.setAttribute("address",user.getAddress());


            resp.sendRedirect("Account");

        }else if (flag == 2){


            resp.sendRedirect("Account");
        }

    }
}
