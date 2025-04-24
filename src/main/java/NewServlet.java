import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
    DBMgr db = DBMgr.getInstance();

    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

    }
}