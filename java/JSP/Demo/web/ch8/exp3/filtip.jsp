<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 2019/6/30
  Time: 上午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>filter req ip test</title>
</head>
<body>
    对不起，你的IP地址是：<%=request.getAttribute("reqIP")%><br>
    不在服务范围内!<br>
    web.xml设置的合法地址范围是：<br>
    xml设置的startIP=<%=request.getAttribute("startIP")%><br>
    xml设置的endIP=<%=request.getAttribute("endIP")%><br>
</body>
</html>
