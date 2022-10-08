package xia.xiao.fei;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    // request对象创建的时间点
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    // request对象销毁的时间点
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
