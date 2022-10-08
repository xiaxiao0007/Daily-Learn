import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");

        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);

            count = ps.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            };
        }finally {
            DBUtil.close(conn,ps,null);
        }

        //判断是否删除成功
        if (count == 1){
            //删除成功
            //仍然要跳转到部门列表页面
            //转发
            // req.getRequestDispatcher("/dept/list").forward(req,resp);
            // 使用重定位
            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            //删除失败,这个路径使不需要写项目名的
            //req.getRequestDispatcher("/index.html").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
