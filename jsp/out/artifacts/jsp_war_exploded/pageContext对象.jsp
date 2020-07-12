<%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //pageContext：即可以放入自己的域中，也可以放在其他域中 request session application
        pageContext.setAttribute("pageDate","当前页");
        pageContext.setAttribute("requsetDate","request数据",PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("sessionDate","session数据",PageContext.SESSION_SCOPE);
        pageContext.setAttribute("applicationDate","application数据",PageContext.APPLICATION_SCOPE);
    %>
    <%
        //从四个域获取数据
        String pageDate = (String)pageContext.getAttribute("pageDate");
        String requsetDate = (String)pageContext.getAttribute("requsetDate",PageContext.REQUEST_SCOPE);
        String sessionDate = (String)pageContext.getAttribute("sessionDate",PageContext.SESSION_SCOPE);
        String applicationDate = (String)pageContext.getAttribute("applicationDate",PageContext.APPLICATION_SCOPE);

        //从所有域中查找
        String pageDate1 = (String)pageContext.findAttribute("pageDate");
        //从所有域中移除
        pageContext.removeAttribute("pageDate");
    %>
    <%=pageDate%>
    <%=requsetDate%>
    <%=sessionDate%>
    <%=applicationDate%>
</body>
</html>
