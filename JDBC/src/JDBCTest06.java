import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest06 {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;//连接通道
        Statement statement = null;//数据库操作对象
        ResultSet rs = null;

        //1.注册驱动
        try {
            Class.forName(bundle.getString("driver"));

            //2.打开连接
            connection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("password") );

            //3.获取数据库操作对象
            statement = connection.createStatement();

            //4.执行sql语句
            //int executeUpdate(insert/delete/update)
            //ResultSet executeQuery(select)
            String sql = "select empno,ename,sal from emp";
            rs = statement.executeQuery(sql);//专门执行DQL语句的方法

            //5.处理查询结果集
            /*
            boolean bool = rs.next();
            //System.out.println(bool);
            if (bool){
                //光标指向的行有数据
                //取数据
                //getString()方法的特点是：不管数据库中的数据类型是什么，都以String的形式取出
                //以下程序的1 2 3 说的第几列
                String empno = rs.getString(1);//JDBC中所有下标从1开始。不是从0开始
                String ename = rs.getString(2);
                String sal = rs.getString(3);
                System.out.println(empno+","+ename+","+sal);
            }
            * */

            while (rs.next()){
                //这个不是以列的下标获取，以列的名字获取
                //以查询结果之后的列名称
                //String empno = rs.getString("empno");
                //String ename = rs.getString("ename");
                //String sal = rs.getString("sal");

                //除了可以以String类型取出之外，还可以以特定的类型取出(以什么类型取出数据库中的数据)
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                double sal = rs.getDouble("sal");
                System.out.println(empno+","+ename+","+(sal+100));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6.释放资源
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
