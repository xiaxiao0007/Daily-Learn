package Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();
        // 获取session对象
        HttpSession session = request.getSession(false);// jsp内置对象创建了session对象
        /*if ("index.html".equals(servletPath)||"/welcome".equals(servletPath)||
                "/user/login".equals(servletPath)||
                "/user/exit".equals(servletPath)
                ||(session != null && session.getAttribute("username") != null)) */
        if ("index.html".equals(servletPath)||"/welcome".equals(servletPath)||
                "/dept/login".equals(servletPath)||
                "/dept/exit".equals(servletPath)
                ||(session != null && session.getAttribute("user") != null)) {
            chain.doFilter(request,response);
        }else{
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/index.html");
        }
    }
}
