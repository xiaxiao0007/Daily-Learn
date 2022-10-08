<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/3/26
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charser=UTF-8"%>
<%
  request.setAttribute("username","user");
%>

${username}
<br>

<%-- 使用EL表达式获取应用的根目录 --%>
${pageContext.request.contextPath}