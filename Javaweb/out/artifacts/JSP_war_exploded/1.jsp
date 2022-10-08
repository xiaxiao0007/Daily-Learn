<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/4/6
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
在EL表达式中对null进行了处理
--%>
<%--
1.EL表达式可以确定在什么域取数据

2.JSP中EL表达式的隐含对象
    1.pageContext
    2.param
    3.paramValues
    4.initParam
    5.其它（不是重点）
--%>
<%-- 获取用户提交的数据 --%>
<%-- param获取的是请求参数一维数组当中的第一个元素 --%>
用户名：${param.username}

<%-- 获取用户提交的多组数据 --%>
一维数组：${paramValues.aihao}
<%-- 获取数组当中的元素:[下标] --%>
爱好：${paramValues.aihao[0]}