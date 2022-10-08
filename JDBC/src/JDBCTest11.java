import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
* JDBC的事务机制
*   1.JDBC中的事务是自动提交的，什么是自动提交？
*       只要执行任意一条DML语句，则自动提交一次，这是JDBC默认的事务行为
*       但是在实际的业务当中，通常都是N条DML语句共同联合才能完成的，必须保证他们这些DML语句在同一
*       个事务中同时成功或者同时失败
*   2.以下程序先来验证一下JDBC的事务是否是自动提交机制
*       测试结果：JDBC中只要执行任意一条DML语句，就提交一次
* */
public class JDBCTest11 {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );

            //获取预编译数据库操作对象
            String sql = "update dept set dname = ? where  deptno = ?";
            ps = connection.prepareStatement(sql);

            //第一次给占位符传值
            ps.setString(1,"x部");
            ps.setInt(2,50);
            //执行sql语句
            int count = ps.executeUpdate();
            System.out.println(count);

            //如果中间程序出现错误，则下面的的程序不会执行，就会导致数据库更新错误，影响安全性

            //重新给占位符传值
            ps.setString(1,"y部");
            ps.setInt(2,60);
            //执行sql语句
            int count1 = ps.executeUpdate();
            System.out.println(count1);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
