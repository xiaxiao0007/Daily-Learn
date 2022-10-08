<%-- 全局刷新 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新</title>
  </head>
  <body>
      <p>全局刷新</p>
      <form action="${pageContext.request.contextPath}/bmi" method="get">
        姓名：<input type="text" name="name"/><br/>
        体重：<input type="text" name="w"/><br/>
        身高：<input type="text" name="h"/> <br/>
        <input type="submit" value="提交"/>
      </form>
  </body>
</html>
