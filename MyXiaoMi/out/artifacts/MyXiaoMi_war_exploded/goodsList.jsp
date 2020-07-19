<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/19
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<c:forEach items="${pageBean.data}" var="item">
    ${item.name}<br/>
</c:forEach>
<div>
    <div>${pageBean.pageCount}</div>
    <div>${pageBean.pageNum}</div>
    <div>${pageBean.pageSize}</div>
    <a href="${pageContext.request.contextPath}/goods?method=getFoodsByTypeId&pageNum=1&pageSize=${pageBean.pageSize}&typeid=${typeid}">首页</a>
    <a href="${pageContext.request.contextPath}/goods?method=getFoodsByTypeId&pageNum=${pageBean.pageNum+1}&pageSize=${pageBean.pageSize}&typeid=${typeid}">上一页</a>
    <a href="${pageContext.request.contextPath}/goods?method=getFoodsByTypeId&pageNum=${pageBean.pageNum+1}&pageSize=${pageBean.pageSize}&typeid=${typeid}">下一页</a>
    <a href="${pageContext.request.contextPath}/goods?method=getFoodsByTypeId&pageNum=${pageBean.pageCount}&pageSize=${pageBean.pageSize}&typeid=${typeid}">尾页</a>
</div>
</body>
</html>
