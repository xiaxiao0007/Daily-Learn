<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/4/6
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- uri是炸包中的tcb文件，tcb文件是xml配置文件 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //创建List集合
    List<Student> stulist = new ArrayList<Student>();

    //创建Student对象
    Student s1 = new Student(001,"lisi");
    Student s2 = new Student(002, "zhangsan");
    Student s3 = new Student(003,"wanger");

    //添加到List集合中
    stulist.add(s1);
    stulist.add(s2);
    stulist.add(s3);

    //将List集合存储到request域当中
    request.setAttribute("stulist",stulist);
%>

<%-- 对List集合中元素遍历并输出到浏览器上 --%>
<%-- var后面的名字是随意的，var属性代表的是集合中的每一个元素 --%>
<%--底层实际上，会将s存储到pageContext域当中--%>
<c:forEach items="${requestScope.stulist}" var="s" varStatus="varStatus">
    编号;${varStatus.count}id:${s.id},name:${s.name}<br>
</c:forEach>
<%--var用来指定循环中的变量--%>
<%--begin开始--%>
<%--end结束--%>
<%--step步长--%>
<%--底层实际上，会将i存储到pageContext域当中--%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}<br>
</c:forEach>

<c:if test="boolean类型，支持EL表达式">

</c:if>

<c:choose>
    <c:when test=""></c:when>
    <c:when test=""></c:when>
    <c:when test=""></c:when>
    <c:otherwise></c:otherwise>
</c:choose>