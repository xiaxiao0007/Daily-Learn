package march.eleven.javaweb.adapter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericlServlet {
    /*
    * 思考一个问题：有没有一种可能，需要我在LoginServlet类中重写init方法?
    *   当然有可能，于是乎就重写了init方法
    *
    * 父类将init方法final了，我子类没有办法重写这个init方法了
    * 如果这个时候我还是希望能够重写init方法，该怎么办？
    *   在父类中重新描写一个init方法
    * */

    @Override
    public void init() {
        System.out.println("带哦用init方法");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("adapter起步");

        ServletConfig config = this.getServletConfig();
        System.out.println("config信息：" + config);
    }
}
