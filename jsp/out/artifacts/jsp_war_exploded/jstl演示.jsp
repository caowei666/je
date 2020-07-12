<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/13
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<h1>通用标签：set,out,remove</h1>
<h3>set:向域中设置数据</h3>
<c:set var="username" value="曹伟"></c:set>
<c:set var="address" value="中国"></c:set>
<c:set var="content" value='<script type="text/javascript">alert("欢迎使用jstl")</script>'></c:set>
${username}
<%--${content}--%>
<c:out value="${address}"></c:out>
<c:out value="${content}"></c:out>  //安全
<%--<script type="text/javascript">alert("欢迎使用jstl")</script>--%>
<c:remove var="address"></c:remove>
<c:out value="${address}"></c:out>
<h1>if,choose的使用</h1>
<c:if test="${empty user}">没有登录</c:if>
<c:set var="score" value="80"></c:set>
<c:choose>
    <c:when test="${score>90}">优秀</c:when>
    <c:when test="${score>=80}">良好</c:when>
    <c:when test="${score>=70}">中等</c:when>
    <c:when test="${score>=60}">及格</c:when>
    <c:otherwise>不及格</c:otherwise>
</c:choose>
<h1>foreach使用</h1>
<%
    List<String> list = new ArrayList<>();
    list.add("北京");
    list.add("上海");
    list.add("杭州");
    list.add("深圳");
    pageContext.setAttribute("citys",list);
%>
<%--北京--0--1 上海--1--2 杭州--2--3 深圳--3--4--%>
<c:forEach items="${citys}" var="c" varStatus="vs">
    ${c}--${vs.index}--${vs.count}
</c:forEach>
<c:forEach var="n" begin="1" end="10">
    ${n}
</c:forEach>
<c:url var="loc" value="/stu.jsp">
    <c:param name="username" value="曹伟"></c:param>
</c:url>
<a href="${loc}">学生列表</a>
<%
    pageContext.setAttribute("mydate",new Date());
%>
<fmr:formatDate value="${mydate}" pattern="yyyy-MM-dd"></fmr:formatDate>

</body>
</html>

