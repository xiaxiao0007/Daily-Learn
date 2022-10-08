import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object userObj = req.getAttribute("userObj");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("请求域当中输出用户对象"+userObj);
    }
}
