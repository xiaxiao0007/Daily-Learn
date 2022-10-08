import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 从web服务器当中获取session对象，如果session对象没有，则新建
        HttpSession httpSession = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("会话="+httpSession);
    }
}
