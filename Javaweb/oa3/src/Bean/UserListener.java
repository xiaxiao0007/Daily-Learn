package Bean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Objects;

public class UserListener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 用户登录了
        // User类型的对象向session中存放了
        // 获取ServletContext对象
        // application 对象是多线程共享的
        ServletContext application = event.getSession().getServletContext();
        // 获取在线人数
        Object onlineCount = application.getAttribute("onlineCount");
        if (onlineCount == null){
            application.setAttribute("onlineCount",1);
        }else {
            int count = (Integer)onlineCount;
            count++;
            application.setAttribute("onlineCount",count);
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 用户退出
        // User类型的对象从session域中删除
        ServletContext application = event.getSession().getServletContext();
        Integer onlineCount = (Integer) application.getAttribute("onlineCount");
        onlineCount--;
        application.setAttribute("onlineCount",onlineCount);
    }

    private String username;
    private String password;

    public UserListener() {
    }

    public UserListener(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListener that = (UserListener) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "UserListener{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
