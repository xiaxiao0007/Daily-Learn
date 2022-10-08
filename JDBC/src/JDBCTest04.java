import java.sql.*;
/*
注册驱动的第一种程序
* */
public class JDBCTest04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try{
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","1215..zx");

            //3.获取数据库操作对象（获取操作数据库的对象）
            statement = conn.createStatement();

            //4.执行sql语句
            //statement.executeUpdate("delete from dept where deptno = 40 ");
            statement.executeUpdate("update dept set dname = '售楼部',loc = '天津' where deptno = 20");

            //5.处理查询结果
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
