/*
实际开发中不建议把连接数据库的信息写死到Java程序中
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCTest05 {
    public static void main(String[] args) {
        //资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection conn = null;
        Statement statement = null;
        try{
            //1.注册驱动
            Class.forName(bundle.getString("driver"));

            //2.获取连接
            conn = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password"));

            //3.获取数据库操作对象（获取操作数据库的对象）
            statement = conn.createStatement();

            //4.执行sql语句
            statement.executeUpdate("delete from dept where dname = '人事部'");

            //5.处理查询结果
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if (statement != null){
                try {
                    statement.close();
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
}
