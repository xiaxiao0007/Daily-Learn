<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/3/30
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
  <head>
    <title>发送cookie</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/cookie/generate">服务器生成cookie，然后将cookie响应给浏览器，浏览器接收cookie</a>
  </body>
</html>
