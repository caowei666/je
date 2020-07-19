<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/18
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="/myxiaomi/login.jsp">登录</a>
  <a href="/myxiaomi/register.jsp">注册</a>
  <h1>欢迎你:${user.username}</h1>
  <%@include file="header.jsp"%>
  </body>
</html>
