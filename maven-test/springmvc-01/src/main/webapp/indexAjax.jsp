<%--
  Created by IntelliJ IDEA.
  User: Xiaooo7
  Date: 2022/5/9
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <%--导入jQuery函数库--%>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <a href="javascript:showList()">访问数据库中的学生集合</a>
    <br>
    <div id="myDiv">学生数据</div>
    <script type="text/javascript">
        function showList(){
            $.ajax({
                url:"${pageContext.request.contextPath}/list.action",
                type:"GET",
                dataType:"json",
                success:function(stuList){
                    var s = "";
                    $.each(stuList,function(i,stu){
                        s +=stu.name + "-----" +stu.age +"<br>"
                    })
                    // 回显数据
                    $("#myDiv").html(s);
                }
            })
        }
    </script>
</body>
</html>
