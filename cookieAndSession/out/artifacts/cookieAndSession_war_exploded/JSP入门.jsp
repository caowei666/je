<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入门</title>
</head>
<body>
    <h2>jsp入门</h2>
    <ul>
        <li>指令page</li>
        <li>脚本</li>
        <li>脚本表达式</li>
        <li>声明</li>
        <li>jsp标签</li>
        <li>静态内容 html css js</li>
    </ul>
    <%
        //脚本
        String name="曹伟";
        int age = 20;
        String address = "北京";
    %>
    <%--脚本表达式--%>
    <%= name%>
    <%= age%>
    <%= address%>
    <%--声明--%>
    <%!
        public String toUpperCase(String s){
            return s.toUpperCase();
        }
    %>
    <%= toUpperCase("hello")%>
    <%= toUpperCase("caowei")%>
</body>
</html>
