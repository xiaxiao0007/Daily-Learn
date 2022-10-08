package march.eleven.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    // 无参数构造
    // 只在用户第一次发送请求的时候才执行，tomcat服务器启动的时候没有创建对象
    public StudentServlet() {
    }

    // init被翻译为初始化
    // init方法只执行一次
    // 在StudentServlet对象第一次被创建之后执行
    // init通常是完成初始化操作
    // init方法在执行的时候StudentServlet对象已经被创建出来了
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    // service方法：是处理用户请求的核心方法
    // 只要用户发送一次请求，service方法必然会执行一次
    // 发送100次请求，service方法则执行100次
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //连接数据库(JDBC)
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //注册驱动

            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","1215..zx");

            //获取操作数据库的预编译命令执
            String sql = "select ename from emp where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,20);

            //执行sql语句
            rs = ps.executeQuery();

            //处理结果查询集
            while(rs.next()){
               String ename = rs.getString("ename");
               out.print(ename+"<br>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /* 释放资源 */
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (ps != null){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rs != null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // destroy方法只执行一次
    // tomcat服务器在销毁StudentServlet对象之前会调用一次destroy方法
    // destroy方法执行的时候，StudentServlet对象的内存还没有被销毁，即将被销毁
    // destroy方法中可以编写销毁前的准备
    // 比如说：服务器关闭的时候，StudentServlet对象开启了一些资源，这些资源可能是流，可能是数据库连接
    // 那么，关闭数据库的时候，关闭这些流，关闭这些数据库连接，那么这些关闭数据库的代码就可以写到destroy方法当中
    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
