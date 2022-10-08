<%@ page import="java.util.List" %>
<%@ page import="Bean.Dept" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门列表</title>
    <script type='text/javascript'>
        function del(dno) {
            if (window.confirm('亲，要删除么')) {
                window.location.href ='${pageContext.request.contextPath}/dept/delete?deptno='+dno;
            }
        }
    </script>
    <%-- 在js代码中要写全路径 --%>
    <%--<base href="http://localhost:8080/oa3/">--%>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<h2>欢迎，在线人数${onlineCount}人</h2>
<br>
<h2><a href="dept/exit">【退出】</a></h2>
<h1>部门列表</h1>
<br>
<table border=1px align='center' width='50%' height='20px' >
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门位置</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${depts}" var="dept" varStatus="deptStatus">
        <tr>
            <td>${deptStatus.count}</td>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
            <td>
                <a href='javascript:void(0)' onclick='del(${dept.deptno})'>删除</a>
                <a href='dept/detail?flag=edit&deptno=${dept.deptno}'>修改</a>
                <a href='dept/detail?flag=detail&deptno=${dept.deptno}'>详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <hr>
    <a href='add.html'>新增部门</a>
</body>
</html>
