<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/5/7
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--导入jstl格式化标签--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <%--导入jstl标签库--%>
    <%--导入jstl格式化标签--%>
</head>
<body>
<br><br><br>
    <form method="get" action="${pageContext.request.contextPath}/req.action">
        <input type="submit" value="提交">
    </form>

    <h2>1.单表数据提交</h2>
    <form action="${pageContext.request.contextPath}/one.action">
        年龄：<input name="myName"><br>
        姓名：<input name="age"><br>
        <input type="submit" value="提交">
    </form>

    <h2>2.对象封装数据提交</h2>
    <form action="${pageContext.request.contextPath}/one.action">
        年龄：<input name="myName"><br>
        姓名：<input name="age"><br>
        <input type="submit" value="提交">
    </form>


</body>
</html>
