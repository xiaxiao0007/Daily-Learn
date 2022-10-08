import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {

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

            String sql = "update dept set dname=?,loc=? where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);

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
            // 可以使用重定向，这里用的是转发，都是一次请求
            // req.getRequestDispatcher("/dept/list").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            //req.getRequestDispatcher("/index.html").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
