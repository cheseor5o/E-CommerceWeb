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
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));

        UserDAO dao = new UserDAOImpl();

        int flag = 0;

        try {
            flag = dao.queryByUsername(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == 1){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username",user.getUsername());
            httpSession.setAttribute("password",user.getPassword());

            String Login_name = (String) httpSession.getAttribute("username");
            UserDAO userDAO = new UserDAOImpl();
            List<User> list = userDAO.selectByUsername(Login_name);
            String name = list.get(0).getName();
            String gender = list.get(0).getGender();
            String birthday = list.get(0).getBirthday();
            String phone = list.get(0).getPhone();
            String email = list.get(0).getEmail();
            String address = list.get(0).getAddress();

            httpSession.setAttribute("name",name);
            httpSession.setAttribute("gender",gender);
            httpSession.setAttribute("birthday",birthday);
            httpSession.setAttribute("phone",phone);
            httpSession.setAttribute("email",email);
            httpSession.setAttribute("address",address);

            req.setAttribute("list",list);

            resp.sendRedirect("Index");
        }
        else {
            resp.sendRedirect("Login");
        }

    }
}
