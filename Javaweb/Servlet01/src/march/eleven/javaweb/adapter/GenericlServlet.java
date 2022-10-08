package march.eleven.javaweb.adapter;

import jakarta.servlet.*;

import java.io.IOException;

// 使用了多态
/*
* 对GenericServlet进行改造
* */
public abstract class GenericlServlet implements Servlet {

    // 成员变量
    private ServletConfig config;
    /*
    init方法中的ServletConfig对象是小猫咪创建的
    这个ServletConfig对象目前在init方法的参数上，属于局部变量
    那么ServletConfig对象肯定以后要在service方法中使用，怎么才能保证ServletConfig对象在service方法中使用呢？
        使其成为成员变量
    初始化会调用init()方法
    */
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        //调用init方法
        this.init();
    }

    // 这个方法是供子类重写的
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
