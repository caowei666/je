<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/8/23
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/add.html" method="post">
        部门名：<input type="text" name="name">
        <input type="submit" value="add">
    </form>
    <c:forEach items="${list}" var="d">
        ${d.id}-${d.name}<br/>
    </c:forEach>
</body>
</html>
