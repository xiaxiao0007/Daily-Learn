/*
* 事务机制的演示
*   重点三行代码
*       connection.setAutoCommit(false);//开启事务
*       connection.commit();//提交事务
*       connection.rollback();//回滚事务
*   遇到异常就需要回滚
* */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCTest12 {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );
            //将自动提交机制修改为手动提交
            connection.setAutoCommit(false);//开启事务

            //获取预编译数据库操作对象
            String sql = "update table_act set balance = ? where  actno = ?";
            ps = connection.prepareStatement(sql);
            //第一次给占位符传值
            ps.setDouble(1,10000.0);
            ps.setInt(2,111);
            //执行sql语句
            int count = ps.executeUpdate();
            System.out.println(count);

            //重新给占位符传值
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            //执行sql语句
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "转账成功":"转账失败");

            //程序能够走到这里说明以上程序没有异常，事务结束，手动提交数据
            connection.commit();//提交事务

        } catch (Exception e) {
            //如果在程序的执行多个sql过程中，其中出现了错误，需要回滚事务
            if (connection != null){
                try {
                    connection.rollback();//回滚事务
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
