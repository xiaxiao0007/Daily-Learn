import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
* PreparedStatement完成INSERT，DELETE，UPDATE
* */
public class JDBCTest10 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(bundle.getString("driver"));

            connection = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("user"), bundle.getString("password") );

            // String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            // String sql = "update dept set deptno = ? where danme = ? ";
            // 设置的是与数据库表设置的类型相关
            String sql = "delete dept where deptno = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,50);
            ps.setString(2,"销售部");
            ps.setString(3,"北京");

            ps.executeUpdate();
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
