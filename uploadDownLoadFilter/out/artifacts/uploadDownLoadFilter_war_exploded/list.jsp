<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/15
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>下载列表</h2>
    <C:forEach items="${maps}" var="entry">
        ${entry.value}------<a href="${pageContext.request.contextPath}/down?filename=${entry.key}">下载</a>
    </C:forEach>
</body>
</html>
