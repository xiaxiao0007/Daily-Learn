import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie = new Cookie("productID", "product");

        // 设置cookie的有效时间
        cookie.setMaxAge(60*60);
        // 设置cookie的有效期为0，表示该cookie被删除，主要应用在，使用这种方式删除浏览器上同名cookie
        // cookie.setMaxAge(0);

        // 默认情况下，当请求path是/session/cookie以及其子路径请求时，都会向服务器中发送cookie中的数据
        cookie.setPath("/session");// 当path是"/session"及其子路径请求时，会向服务器发送cookie中的数据

        // 将cookie响应到浏览器
        response.addCookie(cookie);
    }
}
