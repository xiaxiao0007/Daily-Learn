package March.fourteen.javaweb.servlet03;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
ServletConfig
    1.ServletConfig是什么？
        Jakarta.servlet.ServletConfig
        显然ServletConfig是Servlet规范中的一员
        ServletConfig是一个接口。（Jakarta.servlet.Servlet也是一个接口）
    2.谁去实现了这个接口呢？ （WEB服务器实现了）
        public class org.apache.catalina.core.StandardWrapperFacade implement ServletConfig{}
        结论：Tomcat实现了ServletConfig接口
        思考：如果把Tomcat服务器换成jetty服务器，输出ServletConfig对象的时候，还是这个结果吗？
            不一定一样，包名和类名可能和Tomcat不一样，但是他们都实现了ServletConfig这个规范
    3.一个Servlet对象中有一个ServletConfig对象。
    4.ServletConfig对象是谁创建的？在什么时候创建的？
        Tomcat服务器（WEB服务器）创建了ServletConfig对象
        在创建Servlet对象的时候，同时创建ServletConfig对象
    5.ServletConfig接口到底是干啥的？有什么用？
        Servlet对象的配置信息对象
        一个Servlet对象就有一个配置信息
    6.ServletConfig对象中到底包含了什么信息呢？
        <servlet>
            <servlet-name>configtest01</servlet-name>
            <servlet-class>March.fourteen.javaweb.servlet03.ServletConfigTest02</servlet-class>
        </servlet>
        ServletConfig对象中包装的信息是：web.xml文件中<servlet></servlet>标签中的配置信息

        Tomcat小猫咪解析web.xml文件，将web.xml文件中<servlet></>标签中的配置信息自动包装到ServletConfig对象中
    7.ServletConfig接口中的方法
        <servlet>
            <servlet-name>configtest</servlet-name>
            <servlet-class>March.fourteen.javaweb.servlet03.ConfigTextServlet</servlet-class>
            <init-param>
                <param-name>driver</param-name>
                <param-value>com.mysql.cj.jdbc.Driver</param-value>
            </init-param>
            <init-param>
                <param-name>url</param-name>
                <param-value>jdbc:mysql://localhost:3306/test01</param-value>
            </init-param>
        </servlet>
        以上<servlet></servlet>标签中的<init-param></init-param>是初始化参数，这个初始化参数信息会自动被小喵咪封装到
        ServletConfig对象当中
    8.ServletConfig接口中有四个方法
        第一个方法：public String getInitParameter(String name);
        第二个方法：public Enumeration<String> getInitParameterNames();
        第三个方法：public ServletContext getServletContext();
        第四个方法：public String getServletName();
        以上的4个方法，在自己编写的Servlet类当中也可以使用this.调用（这个Servlet继承了GenericServlet）
ServletContext(应用域)
    1.ServletContext是什么？
        ServletContext是接口，是Servlet规范中的一员

    2.ServletContext是谁实现的
        Tomcat服务器（WEB服务器）实现了ServletContext接口
        public class org.apache.catalina.core.ApplicationContextFacade implement ServletContext {}

    3.ServletContext对象是谁创建的？在什么时候创建的？
        ServletContext对象在web服务器启动的时候创建
        ServletContext对象是web服务器创建的
        对于一个webapp来说，ServletContext对象只有一个
        ServletContext对象在服务器关闭的时候销毁

    4.ServletContext怎么理解？
        Servlet对象的上下文对象
        ServletContext对象其实对应的就是整个web.xml文件
        放在ServletContext对象当中的数据，一个项目中的所有的Servlet一定是共享的，ServletContext对象是应用级对象

    5.ServletContext接口中那些常用的方法？
        public String getInitParameter(String name); 通过初始化参数的name获取value
        public Enumeration<String> getInitParameterNames();获取所有的初始化参数的name
        <!-- 上下文的初始化参数,以下的这些配置信息，可以通过ServletContext对象来获取 -->
        <context-param>
            <param-name>pageSize</param-name>
            <param-value>10</param-value>
        </context-param>
        <context-param>
            <param-name>startIndex</param-name>
            <param-value>1</param-value>
        </context-param>
        注意：以上的配置信息属于应用级配置信息，一般一个项目共享的配置信息会放到以上的标签中
        如果你的配置信息只想给某一个servlet作为参考，那么配置到servlet标签当中即可，使用ServletConfig对象来获取

        public String getConTextPath() 获取context path（获取应用上下文的根）

        public String getRealPath(String path)

        通过ServletContext对象也是可以记录日志的
        public void log(String message);
        public void log(String message,Throwable t)
        这些日志信息记录到那了？
            localhost.2022-3-14.log
        Tomcat服务器下面都有那些日志文件
            catalina.2022-3-14.log 服务器端J的ava程序运行的控制信息
            localhost.2022-3-14.log ServletContext对象的log方法记录的日志信息存储到这个文件中
            localhost_access_log.2022-3-14.txt 访问日志

    6.ServletContext对象还有另一个名字：应用域（后面还有其它域，例如：请求域，会话域）
        如果所有用户共享一份数据，并且这个数据很少修改，并且这个数据量很少，可以将这些数据放到ServletContext这个应用域中
        为什么是所有用户共享的数据？
            不是共享的没有意义，因为ServletContext这个对象只有一个。只有共享的数据放进去才有意义
        为什么数据量要小？
            因为数据量比较大的话，太占用堆内存，并且这个对象的生命周期比较长，服务器关闭的时候，这个对象才会被销毁。
            大数据量会影响服务器性能。占用内存较小的数据量可以考虑放进去
        为什么这些共享数据很少的修改，或者说几乎不修改？
            所有用户共享的数据，如果涉及到修改操作，必然会存在线程并发所带来的安全问题，所以放在ServletContext对象中的数据一般都是只读的

        数据量小，所有用户共享，又不修改，这样的数据放到ServletContext这个应用域中，会大大提升效率，因为应用域相当于一个缓存，放到缓存中
        的数据，下次在用的时候，不需要从数据库中再次获取，大大提升执行效率

        存(怎么向ServletContext应用域中存数据)
            public void setAttribute(String name,Object value)
        取(怎么向ServletContext应用域中取数据)
            public void getAttribute(String name)
        删(怎么向ServletContext应用域中删数据)
            public void removeAttribute(String name)
注意：以后我们编写Servlet类的时候，实际上是不会去直接继承GenericServlet类的，因为我们B/S结构的系统，这种系统是基于
     HTTP超文本传输协议的，在Servlet规范当中，提供了一个类叫做HttpServlet，它是专门为HTTP协议准备的一个Servlet类，我们编写的Servlet类要
     继承HttpServlet。（HttpServlet是HTTP协议专用的）使用HttpServlet处理HTTP协议更便捷。但是你需要直到它的继承结构：
        Jakarta.servlet.Servlet(接口)【爷爷】
        Jakarta.servlet.GenericServlet(抽象类)【儿子】
        Jakarta.servlet.http.HttpServlet(抽象类)【孙子】
* */

public class ConfigTextServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        // 获取ServletConfig对象 （this代表当前对象）
        ServletConfig config = this.getServletConfig();
        //输出该对象
        out.print("ServletConfig的对象是：" + config);

        //获取<servlet-name></servlet-name>
        String servletName = config.getServletName();
        //打印输出
        out.print("<br>"+servletName);

        // 通过ServletConfig对象的两个方法，可以获取到web.xml文件中的初始化参数配置信息
        // java.util.Enumeration<java.lang.String> getInitParameterNames() 获取所有的初始化参数的name
        Enumeration<String> stringEnumeration = config.getInitParameterNames();
        //遍历集合
        while(stringEnumeration.hasMoreElements()){//是否有更多元素
            String parameterName = stringEnumeration.nextElement();//取元素
            out.print(parameterName);
            out.print("<br>");
        }

        //java.lang.String getInitParameter(java.lang.String name) 通过初始化参数的name获取value
        String driver = config.getInitParameter("driver");
        out.print(driver);

        String url = this.getInitParameter("url");
        out.print("<br>"+url);


        // 怎么获取ServletContext对象呢？
        //第一种方式： 通过ServletConfig对象获取ServletContext
        ServletContext application = config.getServletContext();
        //输出
        out.print("<br>"+application);//org.apache.catalina.core.ApplicationContextFacade@47df597b
        //第二种方式：通过this也可以获取ServletContext();
        ServletContext application2 = this.getServletContext();
        out.print("<br>"+application2 +"<br>");//org.apache.catalina.core.ApplicationContextFacade@47df597b

        //获取上下文的初始化参数
        Enumeration<String> initParameterNames = application2.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application2.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        //获取context path
        //动态的获取根路径（在Java源代码当中有一些地方可能会需要应用的路径）
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br>");

        // 获取文件的绝对路径
        // 后面的这个路径，加了一个“/”，这个“/”代表的是web的根
        // String realPath = application.getRealPath("/index.jsp"); 可以
        // 你不加“/”，默认也是从根下开始找
        String realPath = application.getRealPath("index.jsp");// 也可以
        out.print(realPath + "<br>");

        /*
        * log
        * 这个日志会自动记录到哪里呢？
        * CATALINA_HOME/logs 目录下
        * */
        application.log("记录日志开启");

        int age = 17;
        if(age < 18){
            application.log("你未成年",new RuntimeException("未成年人不适合"));
        }

        User user = new User("jack",1111);
        //向ServletContext应用域中存数据
        application.setAttribute("userObj",user);
        // 取出来
        Object userObj = application.getAttribute("userObj");
        out.print(userObj + "<br>");
    }
}
