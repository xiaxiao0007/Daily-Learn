package JavaWeb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloHttpServlet extends HttpServlet {
    // 通过无参数构造方法调用对象
    // 没有提供init方法，那么必然执行父类HttpServlet的init方法
    // HttpServlet类中没有init方法，会继续执行GenericServlet类中的init方法
    // 没有提供service方法。那么必然执行父类HttpServlet类的service
    /*
    * 向服务器取数据：get
    * 向服务器存数据：post
    * */
    // 405发生时，一定调用了HttpServlet类中的doGet方法或者doPost方法
    /*
    怎么避免405错误呢？
        后端重写了doGet方法，前端一定要发get请求
        后端重写了doPost方法，前端一定要发post请求
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/type");
        PrintWriter out = resp.getWriter();
        out.print("<h1> 正确方法 <h1>");
    }

}
