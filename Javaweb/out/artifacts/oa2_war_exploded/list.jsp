<%@ page import="java.util.List" %>
<%@ page import="Bean.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门列表</title>
    <script type='text/javascript'>
        function del(dno) {
            if (window.confirm('亲，要删除么')) {
                window.location.href ='<%=request.getContextPath()%>/dept/delete?deptno='+dno;
            }
        }
    </script>
</head>
<body>
<%-- 显示登录用户的名称 --%>
<h2>欢迎【<%=session.getAttribute("username")%>】</h2>
<br>
<h2><a href="<%=request.getContextPath()%>/dept/exit">【退出】</a></h2>
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
    <%
    List<Dept> deptList = (List<Dept>) request.getAttribute("depts");
    int n = 0;
    for (Dept dept:deptList){
    %>
        <tr>
            <td><%=++n%></td>
            <td><%=dept.getDeptno()%></td>
            <td><%=dept.getDname()%></td>
            <td><%=dept.getLoc()%></td>
            <td>
                <a href='javascript:void(0)' onclick='del(<%=dept.getDeptno()%>)'>删除</a>
                <a href='<%=request.getContextPath()%>/dept/detail?flag=edit&deptno=<%=dept.getDeptno()%>'>修改</a>
                <a href='<%=request.getContextPath()%>/dept/detail?flag=detail&deptno=<%=dept.getDeptno()%>'>详情</a>
            </td>
        </tr>
    <%
    }
    %>
</table>
    <hr>
    <a href='<%=request.getContextPath()%>/add.html'>新增部门</a>
</body>
</html>
