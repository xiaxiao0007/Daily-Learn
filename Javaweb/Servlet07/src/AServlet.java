import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Date nowTime = new Date();

        req.setAttribute("systemTime", nowTime);

        //这样做可以么？
        // 在AServlet当中new一个BServlet，然后调用BServlet对象的doGet方法，把request对象传过去
        // BServlet bServlet = new BServlet();
        // bServlet.doGet(req,resp);
        // 我们没有权力去new，Servlet对象，自己new的Servlet对象生命周期不受Tomcat服务器管理

        // 使用Servlet当中的转发机制。
        // 执行AServlet之后，跳转BServlet。(这个资源跳转可以使用转发机制来完成。)
        // 怎么转发？代码怎么写
        // 第一步：获取请求转发器对象,实际上把下一个跳转的资源路径告知Tomcat服务器
        RequestDispatcher rd = req.getRequestDispatcher("/b");
        // 第二步：调用请求转发器RequestDispatcher的forward()方法，进行转发，这两个参数很重要
        rd.forward(req, resp);

        //转发到一个Servlet，也可以转发到以一个HTML，只要是WEB容器当中的合法资源就即可
    }
}
