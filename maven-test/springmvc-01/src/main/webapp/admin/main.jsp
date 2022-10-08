<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--导入jstl标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--导入jstl格式化标签--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>显示多个日期</title>
</head>
<body>
<h2>show................................</h2>

<%--显示集合中元素的日期--%>
<h2>用户集合</h2>
<table width="800px" border="1">
    <tr>
        <th>姓名</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.date}------<fmt:formatDate value="${user.date}" pattern="yyyy-MM-dd" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
