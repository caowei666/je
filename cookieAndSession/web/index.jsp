<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>网站首页</title>
  </head>
  <body>
  <h2>欢迎访问我的网站,登录名是：${username}</h2>
  <a href="loginout" onclick="return confirm('确定要退出吗？')">退出</a>
  </body>
</html>
