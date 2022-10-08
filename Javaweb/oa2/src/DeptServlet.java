import Bean.Dept;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet({"/dept/list","/dept/save","/dept/detail","/dept/delete","/dept/edit","/dept/update"})
public class DeptServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取session对象
        HttpSession session = request.getSession(false);// jsp内置对象创建了session对象
        if (session != null && session.getAttribute("username") != null) {
            String servletPath = request.getServletPath();
            if ("/dept/list".equals(servletPath)) {
                doList(request, response);
            } else if ("/dept/save".equals(servletPath)) {
                doSave(request, response);
            } else if ("/dept/detail".equals(servletPath)) {
                doDetail(request, response);
            } else if ("/dept/delete".equals(servletPath)) {
                doDel(request, response);
            } else if ("/dept/update".equals(servletPath)) {
                doUpdate(request, response);
            }
        }else{
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/welcome");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Dept> depts = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){
                // 将数据封装到对象内的思想，然后放到域中
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                depts.add(dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        request.setAttribute("depts",depts);
        // 这里的路径不需要添加项目名
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

   private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

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
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取部门编号
        String deptno = request.getParameter("deptno");

        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "select dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);

            rs = ps.executeQuery();

            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno, dname, loc);
                request.setAttribute("dept",dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)){
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else if ("edit".equals(flag)){
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String deptno = request.getParameter("deptno");

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

            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }


    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

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
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}
