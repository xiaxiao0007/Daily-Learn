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

public class ListServlet extends HttpServlet {

    // 处理post请求 【糊弄小喵咪】
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取应用的根路径
        String contextPath = req.getContextPath();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String html = "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>" +
                        "<title>欢迎使用oa系统</title></head>" +
                "<script type='text/javascript'>" + "function del(dno){" +
                "if(window.confirm('亲，要删除么')){window.location.href='" +contextPath+
                "/dept/delete?deptno='+dno}}</script>"+
                        "<body><table border=1px align='center' width='50%' height='20px' >" +
                "<tr><th>序号</th><th>部门编号</th><th>部门名称</th><th>部门位置</th><th>操作</th></tr>";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 1;
        try {
            conn = DBUtil.getConnection();

            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                html += "<tr><td>"+(n++)+"</td><td>"+deptno+"</td><td>"+dname+"</td><td>"+loc+"</td><td>" +
                        "<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>&nbsp" +
                        "<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>&nbsp" +
                        "<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a></td></tr>";
            }
            out.print(html+"</table>"+"<hr><a href='"+contextPath+"/add.html'>新增部门</a>"+"</body>"+"</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
