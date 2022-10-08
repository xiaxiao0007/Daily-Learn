import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
* 使用模板类设计模式，解决类的爆炸
*   将之前的每一个Servlet变成一个方法
* */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/dept/list","/dept/save","/dept/detail","/dept/delete","/dept/edit","/dept/update"})
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String servletPath = req.getServletPath();
        if ("/dept/list".equals(servletPath)){
            doList(req,resp);
        }else if ("/dept/save".equals(servletPath)){
            doSave(req,resp);
        }else if ("/dept/detail".equals(servletPath)){
            doDetail(req,resp);
        }else if ("/dept/delete".equals(servletPath)){
            doDel(req,resp);
        }else if ("/dept/edit".equals(servletPath)){
            doEdit(req,resp);
        } else if ("/dept/update".equals(servletPath)){
            doUpdate(req,resp);
        }
    }

    private void doList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取应用的根路径
        String contextPath = req.getContextPath();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String html = "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>" +
                "<title>欢迎使用oa1系统</title></head>" +
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

    private void doSave(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

    private void doDel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

        if (count == 1){

            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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


    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
            resp.sendRedirect(req.getContextPath()+"/dept/list");
        }else{
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
