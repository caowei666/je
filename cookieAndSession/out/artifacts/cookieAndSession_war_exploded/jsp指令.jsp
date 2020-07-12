<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp指令</title>
</head>
<body>
    <%
        ArrayList<String> arrayList = new ArrayList<>();
        Date data = new Date();
    %>
    <%--静态包含 生成一个合并的class--%>
    <%@include file="footer.jsp" %>
    <%--动态包含 生成连个分开的class--%>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
