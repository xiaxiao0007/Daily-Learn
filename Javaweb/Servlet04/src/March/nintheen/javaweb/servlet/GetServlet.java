package March.nintheen.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //响应一些内容到浏览器中
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<h1>sb</h1>");
    }
}
