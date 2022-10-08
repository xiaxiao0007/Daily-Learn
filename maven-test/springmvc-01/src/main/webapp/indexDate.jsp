<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/5/9
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Date insert</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/date.action">
        日期:<input type="date" name="myDate">
        <input type="submit" value="提交">
    </form>

    <a href="${pageContext.request.contextPath}/myDate.action">获取日期时间</a>
</body>
</html>
