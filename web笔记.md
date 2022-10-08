## 转发和重定向

- 转发和重定向有什么区别？

  - 代码上的区别？

    - 转发：

      ```java
      req.getRequestDispatcher("/dept/list").forward(req,resp);
      // 转发是一次请求（即只向浏览器发送了一次URL）
      // 小喵咪内部进行转发操作
      ```

    - 重定向

      ```java
      resp.sendRedirect(req.getContextPath()+"/b");
      // 向浏览器发送了两次URL
      // 这里的路径需要加项目名
      // 浏览器发送请求，请求路径需要添加项目名
      ```

  - 形式上的区别

    - 转发
      - 在浏览器地址栏上发送的请求是：http://localhost:8080/Servlet08/a，最终请求结束之后，浏览器地址栏上还是这个。没有发生变化
      - 在浏览器地址栏上发送的请求是：http://localhost:8080/Servlet08/a，最终请求结束之后，浏览器地址栏是http://localhost:8080/Servlet08/a
    - 重定向（两次请求）

  - 转发和重定向的本质区别

    - 转发：是由web服务器来控制的。A资源跳转到B资源，这个跳转动作是Tomcat服务器内部完成的

      ![](C:\Users\Xiaooo7\AppData\Roaming\Typora\typora-user-images\image-20220324190132791.png)

    - 重定向：是浏览器完成的。具体跳转到那个资源，是浏览器说了算

      ![image-20220324191111991](C:\Users\Xiaooo7\AppData\Roaming\Typora\typora-user-images\image-20220324191111991.png)

- 转发和重定向应该如何选择？什么时候使用转发，什么时候使用重定向？

  - 如果在上一个Servlet当中向request域中绑定了数据，希望下一个Servlet当中把request域里面的数据取出来，使用转发机制
  - 剩下所有的请求均使用重定位【保存不能使用转发机制，因为保存刷新一次就会向数据库保存一下】
    - 删除之后，重定向
    - 修改之后，重定向
    - 保存之后，重定向

- 跳转的下一个资源有没有要求呢？必须是一个Servlet码？

  - 不一定，跳转的资源只是要服务器内部合法的资源即可。包括：Servlet，JSP，HTML

- 刷新一次向服务器请求一次【记住】，刷新时请求创建对象

## Servlet注解，简化配置

- 分析oa项目中的web.xml文件

  - 复杂业务会使web.xml文件的体积变大，且效率较低
  - 使用注解可以是路径直接写到Java类中

- 使用注解+配置文件的开发模式

- 我们的第一个注解

  - 在Serlet类上使用：@WebServlet ，WebServlet注解中由那些属性？

    - name属性：用来指定Servlet的名字。等同于：<servlet-name>
    - urlPatterns属性：用来指定Servlet的映射路径，可以指定多个路径（字符串）
    - loadOnStartUp属性：用来指定在服务器启动阶段是否加载该Servlet。等同于：<load-on-startup>
    - value属性
      - urlPatterns属性一样
    - 需要什么用什么
  
  - 注解的使用格式
  
    - @注解（属性名=属性值，属性名=属性值，属性名=属性值.......）
    - 注解的属性是一个数组，并且数组中只有一个元素，大括号可以省略
  
  - ```java
    import jakarta.servlet.annotation.WebServlet;
    ```

## 分析使用纯粹Servlet开发web应用的缺陷

- 在Servlet当中编写HTML/CSS/JavaScript等前端代码，存在什么问题
  - Java程序中编写前端代码，编写难度大。麻烦
  - Java程序中编写前端代码，显然程序的耦合度非常高
  - Java程序中编写前端代码，代码非常不美观
  - Java程序中编写前端代码，维护成本高
    - 修改小小的一个前端代码，只要改动，就需要重新编译Java代码，生成新的class文件，打一个新的war包，重新发布
- 思考一下，如果是你的话，你准备怎么解决这个问题？
  - 思路很重要。使用什么样的思路去做，去解决这个问题
    - 上面那个Servlet（Java程序）能不能不写了，让机器自动生成。我们程序员只需要写这个Servlet程序中”前端的那段代码“，然后让机器将我们写的”前端代码“自动翻译成”Servlet这种Java程序“。然后机器再自动将”Java编译生成的class“文件。然后再使用JVM调用这个class中的方法。
- 总结一下到目前为止我们所了解的域对象：
  - request（对应类名：HttpServletRequest）
    - 请求域（请求级别）

  - session（对应类名：HttpSession）
    - 会话域（用户级别）

  - application（对应类名：ServletContext）
    - 应用域（项目级别）

  - 这三个域对象的大小关系
    - request<session<application

  - 他们三个域对象都有以下三个公共的方法：
    - setAttribute （向域当中绑定数据）
    - getAttribute（向域中获取数据）
    - removeAttribute（删除域当中的数据）

  - 使用原则：尽量使用小的域


## 关于B/S结构系统的会话机制（session机制）

- 什么是会话？（session）
  - 用户打开浏览器，进行一系列操作，然后最终将浏览器关闭，这个整个过程叫做：一次会话。会话在服务器端也有一个Java对象，这个Java对象叫做：session
  - 回顾：什么是一次请求：用户在浏览器上点击了一下，然后到页面停下来，可以粗略认为是一次请求。
  - 一个会话当中包含多次请求。

- 在Java的servlet规范当中，session对应的类名：HttpSession（Jakarta.servlet.http.HttpSession）

- session机制属于B/S结构的一部分，不同的语言对这种会话机制都有实现

- session对象最主要的作用是：保存会话状态。

- 为什么需要session对象来保存会话状态呢？

  - 因为HTTP协议是一种无状态协议
  - 什么是无状态：请求的时候，B和S是连接的，但是请求结束之后，连接就断了。为什么要设计成这样？使服务器的压力更小

- request（请求域，一个用户的一个操作）<session（会话域，一个用户）<context(应用域，所有用户)

- session的实现原理

  - ```java
    HttpSession httpSession = request.getSession();
    ```

- session的实现原理

  - 在web服务器中有一个session列表。类似于map集合。这个map集合的key存储的是sessionID，这个map集合的value存储的是对应的session对象。用户发送第一次请求的时候：服务器会创建一个新的session对象，同时session对象生成一个ID，然后web服务器会将session的ID发送给浏览器，浏览器将session的ID保存在浏览器的缓存中。当用户发送第二次请求的时候：会自动将浏览器缓存中的sessionID自动发送给服务器，服务器获取sessionID，然后从session列表中查找到对应的session对象
  - <img src="C:\Users\Xiaooo7\AppData\Roaming\Typora\typora-user-images\image-20220330104100622.png" alt="image-20220330104100622" style="zoom:150%;" />


- 为什么关闭浏览器，会话结束？
  - 关闭浏览器之后，浏览器中保存的sessionID消失，下次重新打开浏览器之后，浏览器缓存中没有这个sessionID，自然找不到服务器中对应的session对象。session对象找不到等同于会话结束

- session对象什么时候销毁
  - 超时销毁
  - 手动销毁

- Cookie禁用了，session还能找到么？

  - cookie禁用是什么意思？服务器正常发送cookie给浏览器，但是浏览器不要了，拒收了，并不是服务器不发了

  - 找不到了，每一次请求都会获取新的session对象

- cookie禁用了，session机制还能实现么？
  - 可以，需要使用URL重写机制

    -  ;jsessionid=xxxx //(session的id)


- 
  总结一下到目前为止我们所了解的域对象：

  - request（对应类名：HttpServletRequest）

    - 请求域（请求级别）

    - session（对应类名：HttpSession）
      - 会话域（用户级别）

    - application（对应类名：ServletContext）
      - 应用域（项目级别）

    - 这三个域对象的大小关系
      - request<session<application

    - 他们三个域对象都有以下三个公共的方法：
      - setAttribute （向域当中绑定数据）
      - getAttribute（向域中获取数据）
      - removeAttribute（删除域当中的数据）
  - 使用原则：尽量使用小的域

- session掌握之后，我们怎么解决oa项目中登录问题，怎么能让登录起作用？
  - 登录成功之后，可以将用户的登录信息存储到session当中，也就是说session中如果有用户的信息就代表用户登录成功了。session中没有用户信息，表示用户没有登录过，则跳转到登录页面。

- 销毁session对象


```java
session.invalidate();
```

## Cookie        

- session的实现原理中，每个session对象都会关联一个sessionid，而这个键值对数据就是cookie对象，对于session关联的cookie来说，这个cookie是被保存字浏览器的”运行内存“当中。
- cookie怎么生成？，cookie保存在什么地方？，cookie有啥用？浏览器什么时候会发送cookie，发送那些cookie给服务器呢？
- cookie最终是保存在浏览器客户端上

  - 可以保存运行内存中
  - 也可以保存在硬盘文件上（永久保存）
- cookie有啥用呢？

  - cookie和session机制其实都是为了保存会话的状态
  - cookie是将会话的状态保存在浏览器客户端上（cookie数据存储在浏览器客户端上）
  - session是将会话的状态保存在服务端上。（session对象存储在服务器上）
  - 为什么要有cookie和session机制？因为http协议是无状态（无连接协议）
- 怎么让cookie失效？

  - 超时失效
  - 清除cookie
- HTTP协议中规定：任何一个cookie都是有name和value组成的，name和value都是字符串类型的
- 在Java中，使用response.addCookie(cookie)将cookie数据发送给浏览器
- 在HTTP协议中这样规定的：当浏览器发送请求的时候，会自动携带该path下的cookie数据给服务器。（URL）
- 关于cookie的有效时间
  - 怎么设置时间
    - cookie.setMaxAge(60*60);设置cookie在一小时之后失效
  - 没有设置时间：默认保存在浏览器的运行内存中，浏览器关闭则cookie失效
  - 只要设置cookie的有效时间>0,这个cookie一定会存储到硬盘文件当中

- 使用cookie实现一下十天免登录功能
  - 先实现登录功能
    - 登录成功
      - 跳转到部门列表界面

    - 登录失败
      - 跳转到登录失败界面
  - 修改前端页面
    - 登录页面给一个复选框，复选框后面给一句话：十天内免登录。
  - 修改Servlet中的Login方法
  - 用户再次访问网站的时候，访问这个网站的首页的时候，有两个走向
    - 要么跳转到部门列表页面
    - 要么跳转到登录页面
    - 以上分别有两个走向，这显然需要编写Java程序进行控制的


## JSP

- 将项目部署之后，启动服务器，打开浏览器

  - 实际上访问以上的这个：index.jsp,底层执行的是：index_jsp.class这个Java程序
  - 这个index.jsp会被Tomcat翻译成index_jsp.java文件，然后Tomcat服务器又会将index_jsp.java编译成index_jsp.class文件
  - 访问index.jsp,实际上执行的是index_jsp.class中的方法

- JSP实际上就是一个Servlet

- JSP是什么？

  - JSP是Java程序
  - JSP是：JavaServer Pages。（基于Java语言实现的服务器端的页面）
  - Servlet是JavaEE的13个子规范之一，JSP也是JavaEE的13个子规范之一。
  - JSP是一套规范，所有的web容器都是遵循这套规范的，都是按照这套规范进行的”翻译“
  - 每一个web容器都会内置一个JSP翻译引擎

- 开发JSP的最高境界

  - 眼前是JSP代码，但是脑袋中呈现的是Java代码

- JSP基础语法

  - 在jsp文件中直接编写文字（普通的字符串），都会自动被翻译到哪里？

    - 翻译到servlet类的service方法的out.write("翻译到这里")，直接翻译到双引号里，被Java程序当作普通字符串打印输出到浏览器

  - Jsp的page指令（后面讲），解决响应时中文乱码问题

    - 通过page指令来设置响应的内容类型，在内容类型的最后添加：charset=UTF-8

    - ```jsp
      <%@page contentType="text/html; charser=UTF-8"%>
      ```

  - 怎么在JSP中编写Java程序：
    - <% Java语句; %>
    
      - 在这个符号当中编写被视为Java程序，被翻译到Servlet的service()方法里面，写在方法体中
    
    - <%! Java语句；%>
    
      - 这个Java语句是写在类体之中的，是写在service（）方法的外面的代码
      - 不建议使用，写静态变量和实例变量，如果修改这些变量的话会存在线程安全问题
    
    - JSP的输出语句
    
      - 怎么向浏览器上输出一个Java变量。
    
      - 第一种方式：
    
        ```java
        <% String name = "Jack"; out.write(name)%>
        ```
    
        注意：以上代码中的out是JSP的九大内置对象之一，可以直接拿来用的。当然，必须只能在service()方法内部使用
    
      - 第二种方式：
    
        ```jsp
        <%=%> //这里面的内容会写到out.print()中
        ```
    
    - 访问jsp的时候不生成session对象
    
      - ```jsp
        <%@page session="false" %>
        ```
    
  - bean（实际上符号某种规范的Java类）：JavaBean其实是Java中的实体类，负责数据的封装

- 登录功能的实现了，目前存在的最大的问题：

  - 这个登录功能目前只是一个摆设，没有任何作用，只要用户知道后端的请求路径，照样可以在不登录的情况下访问。

- JSP的指令

  - 指令的作用：指导JSP的翻译引擎如何工作

  - 指令包括那些

    - include指令：包含指令，在JSP中完成静态包含，很少用了。（这里不讲）
    - taglib指令：引用标签库的指令，这个到JJSTL标签库的时候再学习
    - page指令：重点学习page指令

  - 指令的使用语法是什么？

    - <%@指令名 属性名=属性值 属性名=属性值 %>

  - 关于page指令中都有那些常用的属性呢？

    - ```jsp
      <%@page contextType="text/json;charser=UTF-8">
         // 设置响应内容的类型，但同时也可以
      
      <%@page pageEncoding="charser=UTF-8">
      ```

- JSP的九大内置对象

  - .......

## EL表达式

- EL表达式有什么作用？
  - Expression Language （表达式语言）
  - EL表达式可以代替JSP中的Java代码，让JSP文件中的程序看起来更加整洁，美观
  - JSP中夹杂着各种Java代码，例如<%java代码%>，<%=%>等，导致JSP文件很混乱，不好看，不好维护。所以才有了后期的EL表达式
  - EL表达式可以算是JSP语法的一部分。EL表达式归属JSP
- EL表达式出现在JSP主要是：
  - 从某个作用域中取数据，然后将其转换成字符串，然后将其输出到浏览器。这就是EL表达式的功效，三大功效：
    - 第一功效：从某个域中取数据
      - 四个域：
        - pageContext
        - request
        - session
        - application
    - 第二功效：将取出的数据转换成字符串
      - 创建对象，输出时会调用对象的toString（）方法，转换成字符串
    - 第三功效：将字符串输出到浏览器
- EL表达式很好用，基本的语法格式
  - ${表达式}
- EL表达式的使用

## JSTL标签库

- 什么是JSTL标签库
  - Java Standard Tag Lib （Java标准的标签库）
  - JSTL标签库通常结合EL表达式一起使用，目的是让JSP中的Java代码消失
  - 标签是写在JSP当中的，但实际上最终还是要执行对应的Java程序
- 使用JSTL标签库的步骤
  - 第一步：引入JSTL标签库对于的jar包
    - tomcat10之后引入的jar包是
      - Jakarta.servlet.jsb.jstl-2.0.0.jar
      - Jakarta.servlet.jsb.jstl-api-2.0.0.
      - 和mysql驱动程序放在一起
  - 第二步：在JSP中引用要使用的标签库（引入核心库）
  - 第三步：在需要使用标签的位置使用即可，表面是标签，底层是Java程序

- <base>标签可以设置基础的路径

## Fiter过滤器

- 当前OA项目存在什么缺陷
  - DeptServlet，.....，中代码没有得到重复使用
    - 可以使用Servlet规范中的Filter过滤器来解决
    - 过滤器也是和用户的请求路径有关
- Filter是什么，有什么用，执行原理是什么？
  - Filter是过滤器
  - Filter可以在Servlet这个目标程序执行之前添加代码，也可以在目标Servlet执行之后添加代码。之前之后都可以添加过滤规则
  - 一般情况下，都是在过滤器当中编写公共代码。
- 一个过滤器怎么写呢
  - 第一步：编写一个Java类实现一个接口：jarkata.servlet.Filter.并且实现这个接口当中所有的方法
    - init方法：在Filter对象第一次被创建之后调用，并且只调用一次
    - doFilter方法：只要用户发送一次请求，则执行一次，在这个方法中编写过滤规则
    - destroy方法：在Filter对象被释放/销毁之前调用，并且只调用一次
  - 第二步
    - 在web.xml文件中对Filter进行配置。这个配置和Servlet很像
- 注意：
  - Servlet对象默认情况下，在服务器启动的时候不会新建对象的
  - Filter对象默认情况下，在服务器启动的时候会新建对象
  - Servlet，Filter都是单例的

- 目标Servlet是否执行，取决于两个条件
  - 第一：在过滤器当中是否编写了：
  - 第二：用户发送的请求路径是否和Servlet的请求路径一致

- chain.doFilter(request,response);这行代码的作用：
  - 执行下一个过滤器，如果下面没有过滤器，执行最终的Servlet
- 注意：Filter的优先级，天生的就比servlet优先级高
  - /a.do对应一个Filter，也对应一个Servlet，那么一定先执行Filter，然后再执行Servlet

- 关于Filter的配置路径
  - "/*"

- 在web.xml文件中进行配置的时候，Filter的执行顺序是什么/
  - 依靠filter-mapping标签进行配置，越靠上优先级越高

- 过滤器的调用顺序遵循栈的数据结构
- 使用@WebFilter的时候，Filter的执行顺序是怎样的呢？
  - 执行顺序是：比较Filter的类名

- Filter的生命周期
  - 和Servlet对象生命周期一致
  - 唯一区别：Filter对象默认情况下，在服务器启动的时候会新建对象

- Filter过滤器这里有一个设计模式
  - 责任链设计模式
    - 核心思想:在程序运行阶段，动态的组合程序的调用顺序

  - 过滤器最大优点：
    - 在程序编译阶段不会确定调用顺序，因为Filter的调用顺序是配置到web.xml文件中的，只要修改web.xml配置文件中filter-mapping的顺序就可以调整Filter的执行顺序。显然Filter的执行顺序是在程序运行阶段动态组合的。那么这种设计模式被称为责任链设计模式

- 使用过滤器改造OA项目
  - 


## 监听器

- 什么是监听器？

  - 监听器是Servlet规范中的一员。就像Filter一样，Filter也是Servlet规范中的一员
  - 在Servlet中，所有的监听器接口都是以"Listener"

- 监听器有什么作用？

  - 监听器实际上是Servlet规范留给我们Javaweb程序员的特殊时机
  - 特殊的时刻如果想执行这段代码，你需要想到使用对应的监听器

- Servlet规范中提供了那些监听器

  - Jakarta.servlet包下

    - ServletContextListener
    - ServletContextAttributeListener
    - ServletRequestListener
    - ServletRequestAttributeListener

  - Jakarta.servlet.http

    - HttpSessionListener
    - HttpSessionAttributeListener
      - 该监听器需要使用@WebListener注解进行标注
      - 主要检测点在session域对象上
    - HttpSessionBindingListener
      - 该监听器不需要使用@WebListener进行标注
      - 假设User类实现该监听器，那么User对象在被放入session的时候触发bind事件，User对象从session中删除的时候，触发unbind事件
    - HttpSessionIdListener
    - HttpSessionActivationListener

  - 实现一个监听器的步骤：（ServletContextListener为例）

    - 第一步：编写一个类实现ServletContextListener接口，并且实现里面的方法

      - ```java
        public void contextInitialized(ServletContextEvent sce)
         
        public void contextDestroyed(ServletContextEvent sce)
        ```

    - 第二步：在web.xml文件中对ServletContextListener进行配置，如下

      - ```java
        <listener>
                <listener-class>xia.xiao.fei.MyServletContextListener</listener-class>
            </listener>
        ```

      - 当然：第二步也可以不使用配置文件，也可以用注解，例如：@Weblistener

- 注意:所有监听器中的方法都是不需要javaweb程序员调用的，由服务器来负责调用？什么时候被调用呢？

  - 当某个特殊的事件发生（特殊的事件发生其实就是某个时机到了）之后，被web服务器自动调用。

- 思考一个业务场景：

  - 请编写一个功能，记录网站实时的在线用户个数
    - HttpSessionListener
  - 只统计登录用户的在线用户，这个该怎么办？
    - HttpSessionBindingListener		
      - count++，然后存储到ServletContext域中

- 实现oa项目中当前登录在线的人数

  - 什么代表着用户的了？
    - session.setAttribute("user",userobj);user类型的对象只要往session中存储过，表示由新用户登录
  - 什么时候代表用户退出？
    - session.removeAttribute("user");.User类型的对象从session域中移除
    - 或者由可能是session销毁了

## Ajax

- 两种刷新方式
  - 局部刷新
    - Ajax主要用于局部刷新
  - 全局刷新
  
- 局部刷新使用的核心对象是异步对象XMLHttpRequest（通过js语法创建和使用XMLHttpRequest对象）
  - XMLHttpRequest对象存在浏览器的内存中
    - var xmlhttp = new XMLHttpRequest();
  
- Ajax
  - Ajax = Asynchronous JavaScript and XML（异步的Javascript和XML）
  - JavaScript：负责创建异步对象，发送请求，更新页面DOM对象
  - XML：网络中传输的数据格式，使用json替换了XML
  
- 异步对象的使用
  - 第一步：创建异步对象var xmlHttp = new XMLHttpRequest();
  - 第二步：给异步对象绑定事件。xmlHttp.onreadystatechange = function(){}  当异步对象发起请求，获取了数据都会触发这个事件。这个事件需要指定一个函数，在函数中处理状态的变化
  - 第三步：初始化请求对象
    - 异步方法open()
    - xmlHttp.open(请求方式get|post,"服务器端的访问地址"，同步|异步请求（默认是true）)
  - 第四步：使用异步对象发送请求
    - xmlHttp.send（）；
  
- 异步对象（XMLHttpRequest）的属性
  - readyState
    - 0：创建异步对象时，new  XMLHttpRequest()
    - 1：初始化异步请求对象，xmlHttp.open()
    - 2：发送请求 xmlHttp.send()
    - 3：从服务端获取数据，此时3，注意3是异步对象内部使用，获取了原始的数据
    - 4：异步对象把接收的数据处理完成后。此时开发人员在4的时候处理数据，在4的时候，开发人员开始更新当前页面
  - status属性，表示网络请求的状况的
    - 200：请求成功
    - 其它：不成功
  - responseText，为服务器端返回的数据
    - xmlHttp.responseText, 放在处理状态变化的函数里
  
- 回调：当请求的状态变化时，异步对象会自动调用onreadystatechange事件对于的函数

- ```html
  <script>
          function doAjax(){
              var xmlHttpRequest = new XMLHttpRequest();
              xmlHttpRequest.onreadystatechange = function (){
  
                  /*alert("readyState="+xmlHttpRequest.readyState)*/
                  // 当readyState==4和HTTP协议的status == 200 状态码正确时，进行数据传输到前端中
                  if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status ==200){
                      // alert(xmlHttpRequest.responseText);
                      // 设置span标签的内容需要使用innerText
                      document.getElementById("ct").innerText= xmlHttpRequest.responseText;
                  }
  
              }
              // 初始请求数据
              // 获取dom对象的value属性值
              var name = document.getElementById("name").value;
              var w = document.getElementById("w").value;
              var h = document.getElementById("h").value;
  
              var parm = "?name="+name+"&w="+w+"&h="+h;
              /* 这里的路径是不需要加/ */
              xmlHttpRequest.open("get","bmiAjax"+parm,true)
              xmlHttpRequest.send();
          }
      </script>
  ```

  

## jQuery

- jQuery是js的库
- dom对象和jQuery对象
  - dom对象，使用Javascript的语法创建的对象叫做dom对象，也就是js对象
  - jQuery对象：使用jQuery语法表示对象叫做jQuery对象，它是一个数组
  - dom对象和jQuery对象可以相互转换
    - var obj = $(dom对象)
    - [0]

## 代理模式

- 代理模式的作用
  - 控制目标对象的访问
  - 增强功能

- 代理模式的分类
  - 静态代理
  - 动态代理，又称JDK动态代理，CGLib动态代理

- 什么是静态代理
  - 一种代理模式
  - 具备的特点
    - 目标对象和代理对象实现同一个业务接口
    - 目标对象必须实现接口
    - 代理对象在程序运行前就已经存在
    - 能够灵活的进行目标对象的切换，却无法进行功能的灵活处理(使用动态代理解决问题)

- 动态代理

  - 代理对象在程序运行的过程中动态在内存构建，可以灵活的进行业务的切换

- JDK动态代理

  - 目标对象必须实现接口
  - 代理对象不需要实现业务接口
  - JDK动态代理的对象在程序运行前不存在，在程序运行时动态的在内存中构建
  - JDK动态代理灵活的进行业务功能的切换
  - 本类中的方法(非接口的方法)不能被代理

- JDK动态代理用到的类和接口

  - 它是使用现有的工具类完成JDK动态实现

    - Proxy类

      - java.lang.reflect.Proxy包下的类，它有一个方法Proxy.newProxyInstance(....)专门生成动态代理对象

      - ```java
        public static Object newProxyInstance(ClassLoader loader, // 类加载器
            Class<?>[] interfaces,// 得到目标对象实现的所有接口
            InvocationHandler h // 类似代理功能)
        ```

        

    - Method类

      - 反射用的类，用来进行目标对象方法的反射调用

    - InvocationHandler接口

      - 它是实现代理和业务功能的，我们在调用时使用匿名内部类实现

- CGLib动态代理

  - 又称为子类，通过动态的在内存中构建子类对象，重写父类的方法进行代理功能的增强。如果目标对象没有实现接口，则只能通过CGLib子类代理来进行功能增强。
  - 子类代理是对字节码框架ASM来实现的

## MyBatis（优化JDBC）

- 什么是三层架构（将以前servlet功能分成三层）
  - 在项目开发中，遵循的一种形式模式，分为三层
  - 界面层：用来接收客户端的输入，调用业务逻辑层进行功能处理，返回给客户端，过去的servlet就是界面层的功能
  - 业务逻辑层：用来进行整个项目的业务逻辑处理，向上为界面层提供处理结果，向下问数据访问层要数据
  - 数据访问层：专门用来进行数据库的增删改查操作，向上为业务逻辑层提供数据
  - 各层之间的调用顺序是固定的，不允许跨层调用
  - 界面层<------------>业务逻辑层<---------->数据访问层

- SSM框架
  - spring：它是整合其它框架的框架.它的核心是IOC和AOP.它由20多个模块构成。
  - spring-mvc：它是spring家族的一员。专门用来优化控制器（servlet）的，提供了极简单数据提交，数据携带，页面跳转等功能
  - mybatis：是持久化层（数据访问层）的一个框架。用来进行数据库访问的优化，专注于sql语句，极大的简化了JDBC的访问

- 什么是框架
  - 半成品软件。将所以有的公共的，重复的功能解决掉，帮助程序快速高效的进行开发，它是可复用，可扩展的

- 什么是MyBatis框架
  - 功能：完成数据访问层的优化.它专注于sql语句。简化了过去JDBC繁琐的访问机制。

- MyBatis框架的结构
  - 1

- 添加框架的步骤
  - 添加依赖（mybatis和MySQL的依赖）
  - 添加配置文件
  - 具体步骤
    - 新建库建表
    - 新建maven项目，选quickstart模板
    - 修改目录，添加确实的目录，修改目录属性
    - 修改pom.xml文件，添加MyBatis的依赖，添加MySQL的依赖
    - 修改pom.xml文件添加资源文件指定
    - 在idea中添加数据库的可视化
    - 添加jdbc.properties属性文件【数据库的配置】
    - 添加SqlMapConfig.xml文件，MyBatis的核心文件
    - 创建实体类Student，用来封装数据
    - 添加完成学生表的增删改查的功能的StudentMapper.xml文件（用来写sql语句的）
    - 创建测试类，进行功能测试

- 数据库连接池（cache缓存原理，局部sh）

- MyBatis对象分析
  - Resource类
    - 解析SqlMapConfig.xml，创建出响应的对象
  - SqlSessionFactory接口
    - 使用其实现类，生成工厂对象
  - SqlSession接口
    - DefaultSqlSession实现类

- 为实体类注册别名

- 设置日志输出

  - ```xml
    <!--设置日志输出底层执行代码-->
        <settings>
            <setting name="logImpl" value="STDOUT_LOGGING"/>
        </settings>
    ```

- 动态代理意义：实现业务逻辑层对数据层的xml文件的访问

- 动态代理实现的规范

  - UserMapper.xml文件与UserMapper.java的接口必须同一个目录下
  - UserMapper.xml文件与UserMapper.java的接口的文件名必须一致，后缀不管
  - UserMapper.xml文件中标签的id值与UserMapper.java的接口中的方法的名称完全一致
  - UserMapper.xml文件中标签的parameterType属性值与UserMapper.java的接口中方法的参数类型完全一致
  - UserMapper.xml文件中标签的resultType值与UserMapper.java的接口中方法的返回值类型完全一致
  - UserMapper.xml文件中namespace属性必须是接口的完全限定名称
  - 在SqlMapConfig.xml文件中注册mapper文件时，使用class=接口的完全限定名称

- #{}占位符

  - 传参大部分使用#{}
  - 它的底层使用的是PreparedStatement对象，是安全的数据库访问
  - #{}里如何写，看parameterType的类型
    - 如果parameterType的类型是简单类型（8种基本类型（封装）+String），则#{}里随便写
    - parameterType的类型是实体类的类型，则#{}里只能是类中成员变量的名称，而且区分大小写

- ${}字符串拼接或字符串替换

  - 字符串拼接，一般用于模糊查询中，建议少用，因为有sql注入的风险

  - ${}里面如何写，看parameterType的类型

    - 如果parameterType的类型是简单类型（8种基本类型（封装）+String），则#{}里随便写

    - parameterType的类型是实体类的类型，则#{}里只能是类中成员变量的名称，而且区分大小写

    - 优化后的模糊查询

      - ```xml-dtd
        <!--优化后的模糊查询-->
            <select id="getByNameGood" parameterType="string" resultType="student">
                select id,name,email,age
                from student
                where name like concat('%',#{name},'%')
            </select>
        ```

  - 字符串替换${}

  - 需求：模糊地址或者用户名的查询

- 返回主键值

  - 在插入语句结束后，返回自增的主键值到入参的user对象的id属性中

  - ```xml
    <insert id="insert" parameterType="student">
        <selectKey keyProperty="id" resultType="int" order="AFTER">
            select last_insert_id()
        </selectKey>
            insert  into student (name,email,age) values (#{name},#{email},#{age})
    </insert>
    ```

    - keyProperty:student对象那个属性来接收返回的主键值
    - resultType：返回的主键的类型
    - order：在插入语句执行前，还是执行后返回主键值。之前before，之后after

- UUID

  - 这是一个全球唯一字符串，由36个字母数字中划线

  - ```java
    UUID uuid = UUID.randomUUID();
    System.out.println(uuid.toString().replace("-","").substring(20));
    ```

- 动态sql

  - 可以定义代码片段，可以进行逻辑判断，可以进行循环处理（批量处理），使条件判断更为简单

  - <sql>:用来定义代码片段，可以将所有的列名，或复杂的条件定义为代码片段，供使用时调用

  - <include>:用来引用<sql>定义的代码片断

  - <if>:进行条件判断

  - <where>:进行多条件拼接，在查询，删除，更新中使用

    - ```xml
      <select id="getByCondition" parameterType="student" resultType="student">
          select name,email,age
          from student
          <where>
              <if test="name != null and name !=''">
                  and name like concat('%',#{name},'%')
              </if>
              <if test="age != null and age !=''">
                  and age = #{age}
              </if>
          </where>
      </select>
      ```

  - <set>:有选择的进行更新处理，至少更新一列

    - ```xml
      <!--有选择的更新-->
          <update id="updateSet" parameterType="student">
              update student
              <set>
                  <if test="name != null and name != ''">
                      name = #{name},
                  </if>
                  <if test="email != null and email != ''">
                      email = #{email},
                  </if>
                  <if test="age != null and age != ''">
                      age = #{age},
                  </if>
              </set>
              where id = #{id}
          </update>
      ```

  - <foreach>:用来进行循环遍历，完成循环条件查询，批量删除，批量增加，批量更新

    - collection属性：用来指定入参的类型，如果是List集合，则为list，如果是Map集合，则为map，如果是数组，则为array

    - item:每次循环遍历出来或对象

    - separate：多个值或对象或语句之间的分隔符

    - open：整个循环外面的前括号

    - close：整个循环外面的后括号

    - ```xml
      <select id="getByIds"  resultType="student">
          select name,email,age
          from student
          where id in
          <foreach collection="array" item="id" separator="," open="(" close=")">
              #{id}
          </foreach>
      </select>
      ```

- 指定参数位置

  - 如果传入的参数是多个，可以通过指定参数位置进行传参。是实体类包含不住的条件。实体类只能封装住成员变量的条件。如果某个成员变量要有区间范围内的判断，或者有两个值进行处理，则实体类包不住。

  - ```xml
    <!--
      	查询指定年龄范围内的用户
        List<Student> getByAge(Integer begin, Integer end);
    -->
    <select id="getByAge" resultType="student">
        select name,email,age
        from student
        where age between #{arg0} and #{arg1}
    </select>
    ```

- 传入参数是map【重点掌握】

  - 如果传入的参数超过一个以上，使用map封装查询条件，更有语义，查询条件更明确。

- 返回值是map

  - 如果返回的数据实体类无法包含，可以使用map返回多张表中的若干数据。返回后这些数据之间没有任何关系。就是Object类型。返回的key就是列名或者别名。

    - ```xml
      <select id="getReturnMap" parameterType="int" resultType="map">
          select name,age
          from student
          where id=#{id}
      </select>
      ```

  - 返回值是多行的map

    - ```java
      List<Map> getReturnMap(Integer id);
      ```
  
- 使用别名进行成员变量的映射，另一种是用resultMap手动映射

  - ```xml
    <!--使用resultMap手动完成映射-->
    <resultMap id="bookmap" type="book">
        <!--主键绑定-->
        <id property="id" column="bookid"></id>
        <!--非主键绑定-->
        <result property="name" column="bookname"></result>
        <!--多出来的绑定 property的属性值为成员变量名  ofType的属性值为泛型 -->
        <collection property="orderList" ofType="orders" >
        	<!--主键绑定-->
            <id property="id" column="bookid"></id>
            <!--非主键绑定-->
            <result property="name" column="bookname"></result>
        </collection>
    </resultMap>
    <select id="getAll" resultMap="bookmap">
        select bookid,bookname
        from book
    </select>
    ```

- 表之间的关联关系

  - 一对一
  - 一对多
  - 多对多（使用中间表来表示）

- 事务

  - 多个操作同时完成，或者同时失败

  - 事务的特性：一致性，持久性，原子性，隔离性

  - mybatis如何进行事务的管理

    - ```xml
      <transactionManager type="JDBC"></transactionManager>// 程序员自动提交
      ```

- 缓存（和操作系统的缓存原理一样）

  - mybatis框架提供两级缓存，一级缓存和二级缓存，默认开启一级缓存
  - 提高查询效率
  - 如果数据库中发生commit()操作，则清空缓存
  - 一级缓存使用的是SqlSession的作用域，同一个sqlSession共享一级缓存的数据
  - 二级缓存使用的是mapper的作用域，不同的sqlSession只要访问的同一个mapper.xml文件，则共享二级缓存作用域

- ORM对象关系映射

  - MyBatis框架是ORM非常优秀的框架
  - Java语言中以对象的方式操作数据，存到数据库中是以表的方式进行存储，对象中的成员变量与表中的列之间的数据互称为映射，整个这套操作就是ORM
  - 持久化操作：将对象保存到关系型数据库中，将关系型数据库中的数据读取出来以对象的形式封装。

## Spring框架（容器）

- 什么是spring框架
  - 它是一个容器，它是整和其它框架的框架。它的核心是IOC和AOP。它由20多个模块构成，它在很多领域都提供优秀的解决方案

- spring的主要作用就是为了代码的解耦合，降低代码间的耦合度

- spring的特点
  - 轻量级
  - 面向接口编程：使用接口，就是面向灵活，项目可扩展性，可维护性都极高。接口不关心实现类的类型。使用时接口指向实现类，切换实现类即可切换整个功能
  - AOP：面向切面编程（公共的代码部分）
    - 就是将公共的，通用的，重复的代码单独开发，在需要的时候反回去。底层的原理是动态代理
  - 整合其它框架

- Spring框架的体系结构
  - ![image-20220430112735573](C:\Users\Xiaooo7\AppData\Roaming\Typora\typora-user-images\image-20220430112735573.png)

- IOC 控制反转
  - 什么是IOC
    - 控制反转是一个概念，是一种思想。由spring容器进行对象的创建和依赖注入，程序员在使用时直接取出来使用。
    - 正转：由程序员进行对象的创建和依赖注入称为正传。程序员说了算
    - 反转：由Spring容器创建对象和依赖注入（值）称为反转，控制权给了Spring容器

- Spring容器在启动时，就创建所有的对象

- 基于xml的IOC

  - 创建对象

    - ```xml
      创建容器的时候，就创建了对象
      <bean id="stu" class="xia.xiao.pojo.Student" autowire="byName">//基于xml引用类型的自动导入
          <!--简单类型依赖注入-->
          <property name="name" value="张三"></property>
          <property name="age" value="20"></property>
          <!--ref 是依赖注入-->
          <property name="school" ref="school"></property>
      </bean>
      ```

  - 使用对象

    - ```java
      // 如果想从spring容器中取出对象，则要先创建容器对象，并启动才可取对象。
      // 启动容器，同时创建了对象
      ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
      // 从容器中取出对象
      Student stu = (Student) ac.getBean("stu");
      ```

  - 给创建对象赋值

    - 使用setter注入
      - 注入分为简单类型注入和引用类型注入
      - 简单类型注入值使用value属性
      - 引用类型注入值使用ref属性
      - 注意：使用setter注入必须提供无参构造方法，必须提供setXXX()方法
    - 使用构造方法注入
      - 使用构造方法的参数名称进行注入值<constructor-arg name>  【使用name】
      - 使用构造方法参数的下标注入值  【使用index属性】
      - 使用默认的构造方法的参数的顺序注入值  【直接value赋值】

- 项目案列

  - 使用三层架构进行用户的插入操作

  - 界面层，业务逻辑层，数据访问层

  - Spring会接管三层架构中那些对象的创建

  - 非Spring接管下的三层项目构建

    - 实体类 
    - 数据访问层：dao， userMapper.java(接口) UserMapperImpl.java(实现类)
    - 业务逻辑层： service UsersService.java(接口) UserServiceImpl.java（实现类）
    - 界面层：controller UserController.java

- 基于注解的IOC，也称为DI，它是IOC具体实现的技术

  - 基于注解的IOC，必须要在spring的核心配置文件中添加包扫描
  - 创建对象的注解
    - @Component：可以创建任何对象
    - @Controller：专门用来创建控制器的对象（Servlet），这种对象可以接收用户的请求，可以返回处理结果给客户端
    - @Service：专门用来创建业务逻辑层的对象，负责向下访问数据访问层，处理完毕后的结果返回给界面层
    - @Repository：专门用来创建数据访问层的对象，负责数据库中的增删改查所有操作
  - 依赖注入的注解方式
    - 值类型的注入
      - @Value ：用来给简单类型注入值
    - 引用类型注入
      - @Autowired：使用类型注入值，从整个Bean工厂中搜索同源类型的对象进行注入
        - a.被注入的类型（Student中的School）与注入的类型是完全相同的类型
        - b.被注入的类型（Student中的School是父）与注入的类型（子类）是父子类
          - 注意：在有父子类的情况，使用按类型注入，就意味着有多个可注入的对象。此时按照名称进行二次筛选，选中与被注入对象相同名称的对象进行注入
        - c.被注入的类型（Student中的School接口）与注入的类型（实现类）是接口和实现类的类型
          - 注意：
      - @Autowired+@Qualifier：使用名称注入值，从整个Bean工厂中搜索相同的名称的对象进行注入
        - 注意：如果有父子类的情况下，直接按名称进行注入值

- 添加包扫描的方式

  - 单个包扫描（推荐使用）

    - ```xml
      <!--添加包扫描-->
      <context:component-scan base-package="xia.xiao.pojo"></context:component-scan>
      ```

  - 多个包扫描

    - ```xml
      <!--添加包扫描-->
      <context:component-scan base-package="xia.xiao,xia.xiao.service"></context:component-scan>
      ```

  - 扫描根包（不推荐）

    - ```xml
      <context:component-scan base-package="xia.xiao"></context:component-scan>
      ```

- 为应用指定多个Spring配置文件

  - 拆分的策略

    - 按层拆

      - applicationContext_controller.xml

      - ```xml
        <bean id="uController" class="xia.xia.controller.UserController"></bean>
        ```

    - 按功能拆

- spring配置文件的整合

  - 单个文件导入

    - ```xml
      <import resource="applicationContext_uController"></import>
      ```

  - 批量文件导入

    - ```xml
      <import resource="applicationContext_*" // 支持*号的批量导入
      ```

- AOP面向切面的编程

  - 提取出重复代码，使用动态代理，进行织入

- 手写AOP框架

  - 见IDEA里面的代码

- Spring支持的AOP的实现

  - Spring支持AOP编程，常用的有以下的几种
    - Before通知：在目标方法被调用前调用，涉及接口org.springframework.aop.MethodBeforeAdvice;
    - After通知：在目标方法被调用后调用，涉及接口org.springframework.aop.AfterReturningAdvice;
    - Throws通知：在目标方法抛出异常时调用，涉及接口org.springframework.aop.ThrowsAdvice;
    - Around通知：拦截对目标对象方法调用，涉及接口org.aopalliance.intercept.MethodInterceptor;

- AOP常用的术语

  - 切面：就是那些重复的，公共的，通用的功能称为切面。例如：日志，事务，权限
  - 连接点：就是目标方法。因为在目标方法中要实现目标方法的功能和切面功能
  - 切入点（Pointcut）：指定切入的位置。多个连接点构成切入点。切入点可以是一个目标方法，可以是一个类中的所有方法，可以是某个包下的所有类中的方法。
  - 目标对象：操作谁，谁就是对象
  - 通知（Advice）：来指定切入时机，是在目标方法执行前还是执行后还是出错时，还是环绕目标方法切入切面。

- 什么是AspectJ框架

  - AspectJ是一个优秀的切面的框架，它扩展了Java语言，提供了强大的切面实现。它因为是基于Java语言开发的，所以可以无缝扩展。

- AspectJ常见通知类型

  - 切面的功能由切面的方法来实现

  - AspectJ中常用的通知四种类型
    - 前置通知@Before

      - 切面的方法有个参数是JionPoint
      - JoinPoint：获取目标对象的各种参数

    - 后置通知@AfterReturning

      - 在切面方法中可以更改目标方法的返回值
        - 如果目标方法的返回值是8种基本类型或String的类型，则不可改变
        - 如果目标方法的返回值是引用类型，则可以改变

    - 环绕通知@Around：

      - 通过拦截目标方法的方式，在目标方法前后增强功能的通知，它是功能最强大的通知，一般事务使用此通知，它可以轻易的改变目标方法的返回值

    - 最终通知@After：无论目标方法是否正常执行，最终通知代码都会被执行，同before通知

    - 定义切入点@Pointcut

      - 为execution表达式起别名

      - ```java
        @Pointcut(value = "execution(* xia.xiao.fei02.*.*(..))")
        public void myCUt(){}
        ```

- AspectJ的切入点表达式【掌握】

  - 规范公式

  - execution(访问权限 方法返回值 方法声明(参数) 异常类型)

  - 简化后的公式

  - execution(方法返回值 方法声明(参数) )

  - 用到的符号

    - *代码任意个任意的字符（通配符）
    - .. 如果出现在方法参数中，则代表任意参数。如果出现在路径中，则代表本路径以及其所有的子路径

- AspectJ框架切换JDK动态代理和CGLib动态代理

  - ```xml
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>// 默认是JDK是动态代理，取时必须使用接口类型
    ```

  - ```xml
    <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>// 设置为CGLib动态代理，可以使用接口和实现类接
    ```

  - 使用接口来接是不会出错的

- SM整合的步骤

  - 建表
  - 新建项目
  - 修改目录
  - 修改pom.xml文件，添加相关依赖
  - 添加MyBatis响应的模板（SqlMapConfig.xml和XXXMapper.xml文件）
  - 添加SqlMapConfig.xml文件（Mybatis核心配置文件）
  - 添加applicationContext_mapper.xml
  - 添加applicationContext_service.xml
  - 添加Users和Accounts实体类
  - 添加mapper包，添加UserMapper接口和UserMapper.xml文件开发
  - 添加service包，添加UsersService接口和UsersServiceImpl实现类

- Spring的两种处理事务的方式

  - 注解式的事务
    - @Transactional
    - 可以类上也可以在方法上
  - 声明式事务（必须掌握）来进行事务的控制，在配置文件上添加一次，整个项目遵循的事务的设定
    - 
  - 项目中的所有的事务，必须添加到业务逻辑层上。

- spring中的事务的隔离级别

- Spring事务的传播特性

  - 多个事物之间的合并，互斥等都可以通过设置事务的传播特性来解决。
  - PROPAGATION_REQUIRED：比被包含是事务（增删改必用）
  - PROPAGATION_SUPPORTS：如果上下文中存在事务则加入当前事务，如果没有事务则以非事务方式执行。
  - PROPAGATION_MANDATORY：该传播级别要求上下文中必须存在事务，否则抛出异常。
  - PROPAGATION_REQUIRES_NEW：该传播级别每次执行都会创建新事务，并同时将上下文中的事务挂起，执行完当前线程后再恢复上下文中事务。（子事务的执行结果不影响父事务的执行和回滚）
  - PROPAGATION_NOT_SUPPORTED：当上下文中有事务则挂起当前事务，执行完当前逻辑后再恢复上下文事务。（降低事务大小，将非核心的执行逻辑包裹执行。）
  - PROPAGATION_NEVER：该传播级别要求上下文中不能存在事务，否则抛出异常。
  - PROPAGATION_NESTED：嵌套事务，如果上下文中存在事务则嵌套执行，如果不存在则新建事务。（save point概念）

## SpringMVC

- 什么是SpringMVC
  - 它是基于MVC开发模式的框架，用来优化控制器，它是spring家族的一员，它具备IOC和AOP
  - 什么是MVC
    - 它是一种开发模式，它是模型视图控制器的简称，所有的web应用都是基于MVC开发
    - M：模型层，包含实体类，业务逻辑层，数据访问层
    - V：视图层html，JavaScript，vue等都是视图层，用来显示数据
    - C：控制器，它是用来接收客户端的请求，并返回到客户端的组件，Servlet就是组件
- SpringMVC框架的优点
  - 轻量级的
  - 易上手，容易理解，功能强大
  - 它具备IOC和AOP
  - 完全基于注解开发
- 基于注解的SpringMVC框架的开发步骤
  - 新建项目，选择webapp模板
  - 修改目录，添加确实的test，Java，resource（两套），并修改目录属性
  - 修改pom.xml文件，添加SpringMVC的依赖，添加Servlet的依赖
  - 添加配置springmvc.xml配置文件，指定包扫描，添加视图解析器
  - 删除web.xml配置文件，版本太低，新建web.xml
  - 在web.xml文件中注册springMVC框架（所有的web请求都是基于servlet的）
  - 删除index.jsp页面，并新建，发送请求给服务器
  - 开发控制器（Servlet），它是一个不同的类
  - 添加tomcat进行测试功能
- 分析web请求
  - web请求执行的流程
    - index.jsp<--------->DispatcherServlet（核心处理器）<------->SpringMVC的处理器是一个普通的方法
    - DispatcherServlet要在web.xml中注册才能用
- @RequestMapping注解详解
  - 此注解可加在方法上，是为此方法注册一个可访问的名称（路径）
  - 此注解可以加在类上，相当于是包名（虚拟路径），区分
  - 此注解可区分get请求和post请求
- Springmvc优化的内容
  - 提交数据到action，获取数据前端传来的数据
  - action方法的返回值
  - 页面跳转的四种方式
  - 携带数据跳转
- 数据提交的优化，获取数据前端传来的数据方式进行优化
  - 散提交数据
  - 对象封装提交数据：在提交请求中，保证请求参数的名称和实体类中成员变量的名称一致，自动创建对象，可以自动提交数据，自动类型转换
  - 动态占位符提交：仅限于超链接或地址栏提交数据，它是一杠一值，使用注解来解析@PathVariable
  - 映射名称不一致：提交请求参数与action方法的形参的名称不一致，使用注解来解析@RequestParameter
  - 手工提取数据：HttpServletRequest
- 中文乱码的解决方案
  - 配置过滤器，在web.xml中配置过滤器
- action方法的返回值
  - String：客户端资源的地址，自动拼接前缀和后缀。还可以屏蔽自动拼接字符串，可以指定返回的路径
  - Object：返回json格式的对象，自动将对象或集合转为json,使用的jackson工具进行转换，必须要添加Jackson依赖。一般用Ajax请求
  - void：无返回值，一般用于ajax请求
  - 基本数据类型，用于Ajax请求
- 完成Ajax请求访问服务器，返回学生集合
  - 添加Jackson依赖
  - 在webapp目录下新建js目录，添加JQuery函数库
  - 在index.jsp页面上导入函数库
  - 在action上添加注解@ResponseBody，用来处理Ajax请求
  - 在springmvc.xml文件中添加注解驱动<mvc:annotationdriven/>,它用来解析@ResponseBody注解
- SpringMVC默认的参数类型
  - HttpServletRequest
  - HttpServletResponse
  - HttpSession
  - Model
  - Map
  - ModelMap
  - 注意：Map,Model,ModelMap和request一样，都使用请求作用域进行数据传递
- 日期处理
  - 日期的提交处理
    - 单个日期处理
      - 要使用注解@DateTimeFormat，搭配<mvc:annotation-driven></mvc:annotation-driven>一起使用
    - 类中全局日期处理
      - 写一个日期处理类
  - 日期的显示处理
    - 1.添加依赖jstl，2.在页面上导入标签，3.使用标签显示数据
    - 使用jstl标签库的格式库进行刷新显示
  - 如果使用类的话，可以在日期变量的get方法加jstl注解来显示日期，在set方法添加DateTimeFormat注解来注入日期
- 转发与重定向
- 资源在WEB-IN目录下
  - 此目录下的动态资源，不可直接访问，只能通过请求转发的方式进行访问
- SpringMVC的拦截器
  - 针对请求和响应进行的额外的处理，在请求和响应的过程中添加预处理，后处理和最终处理
  - 拦截器的请求时机
    - preHandle();
    - postHandle();
    - afterCompletion();
  - 拦截器实现的两种方式
    - 继承HanlerInterceptor接口
  - 拦截器实现的步骤
    - 改造登录方法，在session中存储用户信息，用于进行权限验证
    - 开发拦截器的功能。实现HanlerInterceptor接口，重写preHandle()方法
    - 在springmvc.xml文件中注册拦截器
- SSM整合的步骤
  - 建库，建表
  - 新建Maven项目，选择webapp模板
  - 修改目录
  - 修改pom.xml文件
  - 添加jdbc.properties属性文件
  - 添加SqlMapConfig.xml文件
  - 添加applicationContext_mapper.xml文件（数据访问层的核心配置文件）
  - 添加applicationContext_service.xml文件（业务逻辑层的核心配置文件）
  - 添加springmvc.xml文件
  - 删除web.xml文件，新建，改名，设置中文编码，并注册springmvc框架，并注册Spring框架
  - 新建实体类user
  - 新建UserMapper.java接口
  - 新建UserMapper.xml实现增删改查所有功能，没有更新
  - 新建service接口和实现类
  - 新建测试类，完成所有功能的测试
  - 新建控制器，完成所有功能
  - 浏览器测试功能

## CRM项目

- crm的技术架构
  - 视图层（view）：展示数据，跟用户交互，HTML，css，js，jQuery 
  - 控制层（controller）
  - 业务层（service）
  - 持久层（Dao/Mapper）
