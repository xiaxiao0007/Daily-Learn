import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String contextPath = req.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<title>修改页面</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>部门修改</h1>");
        out.print("<hr>");
        out.print("<form action='"+contextPath+"/dept/update' method='post'>");

        String deptno = req.getParameter("deptno");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select dname,loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);

            rs = ps.executeQuery();

            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getNString("loc");
                out.print("部门编号<input type='text' name='deptno' value='"+deptno+"' readonly><br>");
                out.print("部门名称<input type='text' name='dname' value='"+dname+"'><br>");
                out.print("部门位置<input type='text' name='loc' value='"+loc+"'><br>");
            }

            out.print("<input type='submit' value='修改'>");
            out.print("</form>");
            out.print("</body>");
            out.print("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
