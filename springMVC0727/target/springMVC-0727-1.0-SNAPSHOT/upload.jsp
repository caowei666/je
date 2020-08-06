<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/8/6
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload1.html" method="post" enctype="multipart/form-data">
    <input name="file" type="file">
    <input name="str" type="text">
    <input type="submit" value="上传">
</form>

<form action="/upload2.html" method="post" enctype="multipart/form-data">
    <input name="file" type="file">
    <input name="file" type="file">
    <input name="file" type="file">
    <input type="submit" value="上传">
</form>

</body>
</html>
