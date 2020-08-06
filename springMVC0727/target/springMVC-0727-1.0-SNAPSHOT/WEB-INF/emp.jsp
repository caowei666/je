<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/8/6
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="emp.html">
        <p>id：<input name="id"></p>
        <p>姓名：<input name="name">${nameError}</p>
        <p>薪资：<input name="salary">${salaryError}</p>
        <p>日期：<input name="hireDate"></p>
        <p><input type="submit" value="提交"></p>
    </form>
</body>
</html>
