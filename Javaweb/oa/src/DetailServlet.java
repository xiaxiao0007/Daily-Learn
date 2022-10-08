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

public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // 获取部门编号
        String deptno = req.getParameter("deptno");
        String html = "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>部门详情</title></head>"+
                "<body><h1>部门详情</h1><hr>";

        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "select dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);

            rs = ps.executeQuery(); //这个结果一定只有一条记录

            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                html += "部门编号:"+deptno+"<br>部门名称:"+dname+"<br>部门位置:"+loc;
            }
            html += "<br><input type='button' value='后退' onclick='window.history.back()'/></body></html>";
            out.print(html);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
