<%-- 使用Ajax进行异步刷新 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax异步刷新</title>
    <script>
        function doAjax(){
            var xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.onreadystatechange = function (){

                /*alert("readyState="+xmlHttpRequest.readyState)*/

                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status ==200){
                    // alert(xmlHttpRequest.responseText);
                    // 设置span标签的内容需要使用innerText
                    document.getElementById("ct").innerText= xmlHttpRequest.responseText;
                }

            }
            // 初始请求数据
            // 获取dom对象的value属性值
            var name = document.getElementById("name").value;
            var w = document.getElementById("w").value;
            var h = document.getElementById("h").value;

            var parm = "?name="+name+"&w="+w+"&h="+h;
            /* 这里的路径是不需要加/ */
            xmlHttpRequest.open("get","bmiAjax"+parm,true)
            xmlHttpRequest.send();
        }
    </script>
</head>
<body>
    <div>
        姓名：<input type="text" id="name" /><br/>
        体重：<input type="text" id="w" /><br/>
        身高：<input type="text" id="h" /> <br/>
        <input type="button" value="计算" onclick="doAjax()"/>
    </div>
    <span id="ct"></span>
</body>
</html>