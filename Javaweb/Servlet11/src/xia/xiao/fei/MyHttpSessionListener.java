package xia.xiao.fei;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    // Session对象创建的时候
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session对象创建了");
    }

    @Override
    // Session对象销毁的的时候
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
