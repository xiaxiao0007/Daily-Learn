package utils;

import java.sql.*;

/*
* JDBC工具类，简化编程
* */
public class DBUtil {

    /*
    工具类中的构造方法都是私有。
    因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */

    private DBUtil() {
    }

    //静态代码块在类加载的时执行，并且只执行一次
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    * 获取数据库连接对象
    *
    * */
    public static Connection getConnection() throws SQLException {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test01"
            ,"root","1215..zx");

    }

    /*
    * 释放资源
    * */
    public static void close(Connection conn, Statement ps, ResultSet rs){//多态

        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
