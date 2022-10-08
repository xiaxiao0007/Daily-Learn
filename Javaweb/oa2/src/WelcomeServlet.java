import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取cookie数组
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for(Cookie cookie:cookies){
                String name = cookie.getName();
                if ("username".equals(name)){
                    username = cookie.getValue();
                }else if ("password".equals(name)){
                    password = cookie.getValue();
                }
            }
        }

        // 要在这里使用username和password变量
        if (username != null && password != null){

            Boolean success = false;

            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = DBUtil.getConnection();
                String sql = "select * from user where user=? and password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);

                rs = ps.executeQuery();

                if(rs.next()){// 最多只有一条语句
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.close(conn,ps,rs);
            }

            String contextPath = request.getContextPath();
            if (success){
                // 如果登录成功创建会话对象
                HttpSession session = request.getSession();// session一定不为空
                session.setAttribute("username",username);

                response.sendRedirect(contextPath+"/dept/list");
            }else{
                //失败界面
                response.sendRedirect(contextPath+"/index.html");
            }
        }else{
            // 跳转到登陆页面
            response.sendRedirect(request.getContextPath()+"/index.html");
        }
    }
}
