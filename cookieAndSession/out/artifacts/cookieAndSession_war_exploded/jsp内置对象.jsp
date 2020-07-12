<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp内置对象</title>
</head>
<body>
    <ul>
        <li>request</li>
        <li>response</li>
        <li>session</li>
        <li>application</li>
        <li>config</li>
        <li>exception</li>
        <li>out</li>
        <li>pageContxt</li>
        <li>page</li>
    </ul>
    <%
        //out的使用:jspWriter(字符流)
        String name = "曹伟";
        int age = 25;
        Date date = new Date();
        out.print(age+"<br/>");
        out.print(name+"<br/>");
        out.print(date+"<br/>");
        out.flush();
        PrintWriter out2 = response.getWriter();
        out2.println("曹伟22222");
    %>
</body>
</html>
