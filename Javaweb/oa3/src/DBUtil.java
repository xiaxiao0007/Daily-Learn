/*
   JDBC的工具类
* */

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    // 可以用设置静态变量方法，使静态方法能访问到此变量，在类加载的时候就可以访问静态变量
    private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
    private static String driver = rb.getString("driver");
    private static String url = rb.getString("url");
    private static String user = rb.getString("user");
    private static String password = rb.getString("password");

    static{
        try {
            //注册驱动只需要一次，可以放在静态代码块中
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //获取连接
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
