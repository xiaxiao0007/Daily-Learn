<%@ page import="Bean.Dept" %><%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/3/28
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情列表</title>
</head>
<body>
    <h1>部门详情</h1>
    <hr>
    <%
       Dept dept= (Dept) request.getAttribute("dept");
    %>
    部门编号:<%=dept.getDeptno()%><br>
    部门名称:<%=dept.getDname()%><br>
    部门位置:<%=dept.getLoc()%><br>
    <input type='button' value='后退' onclick='window.history.back()'/>
</body>
</html>
