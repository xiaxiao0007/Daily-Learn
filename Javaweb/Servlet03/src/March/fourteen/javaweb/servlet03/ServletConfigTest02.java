package March.fourteen.javaweb.servlet03;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletConfigTest02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        //输出该对象
        out.print("ServletConfig的对象是：" + config +"<br>");

        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        out.print(servletContext +"<br>");

        //取出存储的数据
        Object userObj = servletContext.getAttribute("userObj");
        out.print(userObj+"<br>");

        System.out.println(Thread.currentThread().getName());
    }
}
