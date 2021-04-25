package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");

        if (username == null){
            //未登录,跳转登录界面
            resp.sendRedirect("Login");
        }else {
            //展示个人信息界面
            resp.sendRedirect("Account");
        }
    }

}
