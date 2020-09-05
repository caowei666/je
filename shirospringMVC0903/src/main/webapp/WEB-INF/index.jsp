<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/9/3
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
首页
<shiro:hasRole name="admin">
    <a href="/role.html">角色管理</a>
</shiro:hasRole>

<a href="/menu/user.html">菜单管理</a>
<a href="/menu/list.html">菜单管理2</a>
</body>
</html>
