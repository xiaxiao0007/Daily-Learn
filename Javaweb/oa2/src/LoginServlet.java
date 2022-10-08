import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/dept/login","/dept/exit"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if ("/dept/login".equals(servletPath)){
            doLogin(request,response);
        }else if ("/dept/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();

            response.sendRedirect(request.getContextPath()+"/index.html");
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        Boolean flag = false;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from user where user=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,password);

            rs = ps.executeQuery();

            if(rs.next()){// 最多只有一条语句
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        String contextPath = request.getContextPath();
        if (flag){
            // 如果登录成功创建会话对象
            HttpSession session = request.getSession();// session一定不为空
            session.setAttribute("username",user);

            //登录成功，并且用户确实选择了“十天免登录”功能
            String cookieflag = request.getParameter("cookieflag");
            if ("flag".equals(cookieflag)){
                //创建cookie对象
                Cookie cookie = new Cookie("username",user);
                Cookie cookie1 = new Cookie("password", password);
                //设置cookie的有效期为十天
                cookie.setMaxAge(60*60*10);
                cookie1.setMaxAge(60*60*10);
                //设置cookie的path
                cookie.setPath(request.getContextPath());
                cookie1.setPath(request.getContextPath());
                //响应cookie给浏览器
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }

            response.sendRedirect(contextPath+"/dept/list");
        }else{
            //失败界面
            response.sendRedirect(contextPath+"/index.html");
        }
    }
}
