<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 2019/6/30
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="post" action="./checkUser.jsp">
        用户名：<input type="text" name="loginName" size="20"><br>
        密&nbsp;&nbsp;码：<input type="password" name="password" size="20"><br>
        <input type="submit" value="提交" onclick="writeSession">
        <input type="reset" value="重置">
    </form>
</body>
</html>
