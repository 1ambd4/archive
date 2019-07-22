<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%=session.getAttribute("userName")%>;
    恭喜登录成功！<br>
    <a href="login.jsp">返回重新登录</a>
</body>
</html>
