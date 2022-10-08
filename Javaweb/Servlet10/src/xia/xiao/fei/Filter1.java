package xia.xiao.fei;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// @WebFilter({"/a.do","/b.do"})
/* 以下这个路径属于模糊匹配中的扩展匹配，以星号开始，注意这种路径不要以/开始 */
// 匹配所有路径 "/*"
@WebFilter("*.do")
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在请求的时候添加过滤规制
        System.out.println("doFilter开始执行");

        // 这里的语句是执行下一个过滤器，如果下一个不是过滤器，则执行目标程序Servlet
        chain.doFilter(request,response);

        // 在响应的时候添加过滤规则
        System.out.println("doFilter结束执行");
    }
}
