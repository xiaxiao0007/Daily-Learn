import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
HttpServletRequest接口中的常用方法？
    request对象实际上又称为"请求域"对象（域=cache）
    "请求域"对象要比"应用域"对象范围小很多。生命周期短很多。请求域只在一次请求内有效
    "请求域"有三个方法
        void setAttribute(String name,Object obj) 存数据
        Object getAttribute(String name) 读数据
        void removeAttribute(String name) 删除数据
    请求域和应用域的选用原则？
        尽量使用小的域对象，因为小的域对象占用的资源较少
* */

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        System.out.println(user);

        String[] hobby = req.getParameterValues("aihao");
        for (String x:hobby){
            System.out.println(x);
        }

        // 获取参数Map集合
        Map<String,String[]> parameterMap = req.getParameterMap();
        // 遍历Map集合（获取Map集合中所有的key，遍历）
        Set<String> keys = parameterMap.keySet();//获取Map集合中的key
        Iterator<String> it =  keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
            String[] aihaos1 = parameterMap.get(key);
            // 遍历一维数组
            for (String x:aihaos1){
                System.out.println(x);
            }
        }

        // 直接通过getParameterNames()这个方法，直接获取这个Map集合的所有key
        Enumeration<String> names = req.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name);
        }
    }
}
