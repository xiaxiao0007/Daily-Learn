import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setNum(11111);
        user.setName("Jack");

        // 将用户对象存储到请求域当中
        req.setAttribute("userObj",user);

        // 转发
        req.getRequestDispatcher("/b").forward(req,resp);

        // 重定向，这个路径需要以项目名开始
        // response对象将这个路径:"/Servlet08/b"响应给浏览器
        // 浏览器有自发的向服务器发送了一次全新的请求:http://localhost:8080/Servlet08/b
        // 所以浏览器一共发送两次请求
        // 第一次:http://localhost:8080/Servlet08/a
        // 第二次:http://localhost:8080/Servlet08/b
        // 最终浏览器地址栏上显示的地址当然是最后一次请求的地址，所以重定向会导致浏览器地址栏上的地址发生改变
        // resp.sendRedirect(req.getContextPath()+"/b");
    }
}
