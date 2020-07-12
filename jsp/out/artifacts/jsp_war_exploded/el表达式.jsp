<%@ page import="com.caowei.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 86133
  Date: 2020/7/12
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式</title>
</head>
<body>
    <%
        //向域中存数据
        pageContext.setAttribute("username","曹伟");
        request.setAttribute("age",18);
        session.setAttribute("gender","男");
        application.setAttribute("address","北京");
        User user = new User("曹伟",18,"caowei@qq.com","北京","13343533950");
        pageContext.setAttribute("user",user);
    %>
    <h1>案例一：获取简单数据</h1>
    <h4>使用脚本表达式</h4>
    <%=pageContext.findAttribute("username")%>
    <%=pageContext.findAttribute("age")%>
    <%=pageContext.findAttribute("gender")%>
    <%=pageContext.findAttribute("address")%>
    <h4>使用el表达式</h4>
    ${"username"}
    ${username}
    ${age}
    ${gender}
    ${address}
    <h1>案例二：获取对象属性</h1>
    ${user.getUsername()}<br/>
    ${user.getAge()}<br/>
    ${user.getEmail()}<br/>
    ${user.getAddress()}<br/>
    ${user.getPhone()}<br/>
    <h1>案例二：使用list和map集合</h1>
    <%
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("杭州");
        list.add("深圳");
        pageContext.setAttribute("citys",list);
        Map<String,String> map = new HashMap<>();
        map.put("china","中国");
        map.put("usa","美国");
        map.put("uk","英国");
        map.put("11","日本");
        pageContext.setAttribute("map",map);
    %>
    ${citys[0]}
    ${citys[1]}
    ${citys[2]}
    ${citys[3]}
    <hr/>
    ${map.china}
    ${map.usa}
    ${map.uk}
<%--如果map的key是数字，用下面方法--%>
    ${map['china']}
    ${map['11']}
    <h1>empty空判断</h1>
    ${empty user?"没有登录":user.username}
    <h1>隐式对象</h1>
    上下文路径：${pageContext.request.contextPath}
</body>
</html>
