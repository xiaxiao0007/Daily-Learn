<%@ page import="Bean.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情列表</title>
</head>
<body>
    <h1>部门详情</h1>
    <hr>
    部门编号:${dept.deptno}<br>
    部门名称:${dept.dname}<br>
    部门位置:${dept.loc}<br>
    <input type='button' value='后退' onclick='window.history.back()'/>
</body>
</html>
