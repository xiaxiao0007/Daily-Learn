package xia.xiao.fei;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    // 向session域当中存储数据的时候，以下方法被WEB服务器调用
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    // 向session域当中存储的数据被删除的时候，以下方法被WEB服务器调用
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    // 向session域当中存储数据被替换的时候，以下方法被WEB服务器调用
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
