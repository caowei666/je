<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/18
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form method="post" action="userservlet?method=regist">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="password" name="password" /><br/>
        确认密码：<input type="password" name="repassword" /><br/>
        邮箱：<input type="email" name="email" /><br/>
        性别：男<input type="radio" name="gender" value="男" checked/>女<input type="radio" name="gender" value="女"/><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
