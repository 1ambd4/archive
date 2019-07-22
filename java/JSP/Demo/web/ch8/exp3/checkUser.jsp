<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 2019/6/30
  Time: 上午10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkUser</title>
</head>
<body>
    <%
        String name = request.getParameter("loginName");
        System.out.println("checkuser.jsp name = " + name);
        session.setAttribute("username", name);
        response.sendRedirect("main.jsp");
    %>
</body>
</html>
