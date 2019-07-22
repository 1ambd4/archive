<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-10
  Time: 上午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logfail.jsp</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String logInfo = (String)session.getAttribute("logInfo");
%>
登录失败，重新登录。<%=logInfo%>
单击<a href="log.jsp">这里</a>返回重新登录。
</body>
</html>
