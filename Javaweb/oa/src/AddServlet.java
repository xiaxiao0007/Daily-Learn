import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);

            count = ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }finally {
            DBUtil.close(conn,ps,null);
        }

        if (count == 1){
            // 转向 不需要写项目名称
            // 转发一次请求，这里都是post请求，会出现405错误
            // 重定向可以解决这个问题
            // req.getRequestDispatcher("/dept/list").forward(req,resp);
            // 使用重定位
            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            //req.getRequestDispatcher("/index.html").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
