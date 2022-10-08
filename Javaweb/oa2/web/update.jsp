<%@ page import="Bean.Dept" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改页面</title>
</head>
<body>
    <h1>部门修改</h1>
    <hr>
    <%
        Dept dept = (Dept)request.getAttribute("dept");
    %>
    <%-- 这里是绝对路径 --%>
    <form action="<%=request.getContextPath()%>/dept/update" method="post">
        部门编号<input type="text" name="deptno" value="<%=dept.getDeptno()%>" readonly><br>
        部门名称<input type="text" name="dname" value="<%=dept.getDname()%>"><br>
        部门位置<input type="text" name="loc" value="<%=dept.getLoc()%>"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>