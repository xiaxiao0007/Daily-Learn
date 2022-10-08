import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "hello",urlPatterns = {"/hello"},loadOnStartup = 1,
initParams = {@WebInitParam(name="driver",value="root")})

// 注意：注解的属性是一个数组，并且数组中只有一个元素，大括号可以省略
// value属性和urlPatterns属性一致，都是用来指定Servlet的映射路径的
// 如果表示路径的属性名是value的话，属性名也是可以省略的

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
