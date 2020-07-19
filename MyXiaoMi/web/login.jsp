<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/19
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form method="post" action="/myxiaomi/userservlet?method=login">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        验证码:<input type="text" name="vcode"><img src="userservlet?method=code" id="img" onclick="changeImg()"><a onclick="return changeImg()">点击换一个</a><br/>
        <input name="auto" type="checkbox"/>两周以内自动登录<br/>
        <input type="submit" value="立即登录">
    </form>
    <h1>${msg}</h1>
    <script type="text/javascript">
        function changeImg() {
            var img = document.getElementById("img");
            img.src="userservlet?n="+Math.random()+"&method=code";
            return false;
        }
    </script>
</body>
</html>
