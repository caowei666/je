<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/15
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginservlet" method="post">
        <input type="text" name="username" placeholder="请输入用户名"><br/>
        <input type="password" name="password" placeholder="请输入密码"><br/>
        <input type="checkbox" name="auto">记住我<input type="submit" value="登录">
    </form>
</body>
</html>
