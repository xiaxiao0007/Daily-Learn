package SuoTest;

import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
* 这个程序开始一个事务，这个事务专门进行查询，并且使用行级锁/悲观锁，锁住相关记录
* */
public class JDBCTest01 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "select ename,sal from emp where job = ? for update";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"clerk");

            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getDouble("sal"));
            }

            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
