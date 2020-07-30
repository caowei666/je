<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/30
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加部门</h1>
<form action="/add.html">
    id:<input name="id">
    名称：<input name="name">
    <input type="submit" value="提交">
</form>
<h1>添加员工</h1>
<form action="/addEmp.html">
    id:<input name="id">
    名称：<input name="name">
    薪水：<input name="salary">
    部门：<input name="dept.id">
    <input type="submit" value="提交">
</form>
<h1>测试多选</h1>
<form action="/param6.html">
    <p>以下防疫只是正确的是：</p>
    <input type="checkbox" name="answer" value="1">勤洗手
    <input type="checkbox" name="answer" value="2">多通风
    <input type="checkbox" name="answer" value="3">少聚会
    <input type="checkbox" name="answer" value="4">戴口罩
    <input type="submit" value="提交">
</form>
</body>
</html>
