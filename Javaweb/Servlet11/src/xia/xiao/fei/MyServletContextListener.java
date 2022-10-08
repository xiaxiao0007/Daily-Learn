package xia.xiao.fei;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    /*
    * 监听器中的方法不需要程序员手动调用，是发生某个特殊事件之后被服务器调用
    * */
    @Override
    public void contextInitialized(ServletContextEvent sce) {// 服务器启动时间点
        // 这个方法是在ServletContext对象被创建的时候调用
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { // 服务器关闭时间点
        // 这个方法是在ServletContext对象被销毁的时候调用
    }
}
