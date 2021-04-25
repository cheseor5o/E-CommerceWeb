package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    public TestServlet(){
        System.out.println(1);
    }
    @Override
    public void init() throws ServletException{
        System.out.println(2);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>3</html>");
        out.close();
    }

    public void destory() throws ServletException{
        System.out.println(4);
    }
}
