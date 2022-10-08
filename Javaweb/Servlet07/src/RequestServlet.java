import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestServlet extends HttpServlet {
    /*
    HttpServletRequest是一个接口，全限定名称：Jakarta.servlet.http.HttpServletRequest
    HttpServletRequest接口是Servlet规范中的一员
    HttpServletRequest接口的父接口：ServletRequest
    HttpServletRequest接口的实现类谁写的？HttpServletRequest对象是谁创建的？
        通过测试：org.apache.catalina.connector.RequestFacade实现了HttpServletRequest接口
        测试结果表名：Tomcat服务器实现了HttpServletRequest接口，还是说明了Tomcat服务器实现了Servlet规范
        request接口和response接口的生命周期
            一次请求开启一个request对象和response对象(这两个对象都是Tomcat创建的)
        HttpServletRequest接口有哪些常用方法呢？
            怎么获取前端浏览器用户提交的数据？
                Map<String,String[]> getParameterMap() 这个是获取Map
                Enumeration<String> getParameterNames() 这个是获取Map集合中所有的key
                String[] getParameterValues(java.lang.String name) 根据key获取Map集合的value
                String getParameter(String name) 获取value这个一维数组当中的第一元素。这个方法最常用
        前端传来的数据使用什么数据结构来进行存储？
            使用Map<String,String[]>集合来存放数据
    HttpServletRequest对象这都有什么信息？都包装了什么信息？
        封装了http协议请求协议
    注意：前端表单提交数据的时候，假设提交了120这样的”数字“，其实是以字符串"120"的方式提交的，所以服务器端获取到的一定是一个字符串
    的"120",而不是一个数字。（前端提交的永远是字符串，后端获取的永远是字符串）
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(req);

        // 获取客户端的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户端的IP地址："+remoteAddr);

        // 设置请求体的字符集(处理POST请求的乱码问题，)
        // req.setCharacterEncoding("UTF-8");
        // 不同Tomcat服务器版本之间会出现字符集混乱问题，会出现乱码

        // 获取当前应用的根路径,使用较多（动态获取应用的根路径）
        String contextPath = req.getContextPath();
        System.out.println("应用的根路径："+contextPath);

        // 获取请求方式
        System.out.println(req.getMethod());

        //获取请求的URI
        System.out.println(req.getRequestURI());

        //获取当前Servlet的路径
        System.out.println(req.getServletPath());
    }

}
