<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/13
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
    <h1>学生列表</h1>
    <table>
        <tr>
            <td>学号</td>
            <td>密码</td>
            <td>姓名</td>
            <td>性别</td>
            <td>出生日期</td>
        </tr>
        <c:forEach items="${pageBean.data}" var="stu">
            <tr>
                <td>${stu.studentNo}</td>
                <td>${stu.loginPwd}</td>
                <td>${stu.studentName}</td>
                <td>${stu.sex}</td>
                <td>${stu.bornDate}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="${pageContext.request.contextPath}/liststudentservlet?pageNum=1&pageSize=${pageBean.pageSize}">首页</a>
        <a href="${pageContext.request.contextPath}/liststudentservlet?pageNum=${pageBean.pageNum-1}&pageSize=${pageBean.pageSize}">上一页</a>
        <a href="${pageContext.request.contextPath}/liststudentservlet?pageNum=${pageBean.pageNum+1}&pageSize=${pageBean.pageSize}">下一页</a>
        <a href="${pageContext.request.contextPath}/liststudentservlet?pageNum=${pageBean.pageCount}&pageSize=${pageBean.pageSize}">尾页</a>
    </div>
</body>
</html>
