import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* 这个程序有两个任务
*   第一：测试DBUtil是否好用
*   第二：模糊查询怎么写
* */
public class JDBCTest13 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            //获取预编译的数据操作对象
            String sql = "select ?,? from emp order by ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"ename");
            ps.setString(2,"sal");
            ps.setString(3,"sal");
            //执行sql语句
            rs = ps.executeQuery();

            //处理结果查询集
            while(rs.next()){
                System.out.println(rs.getString("ename")+","+rs.getString("sal"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
