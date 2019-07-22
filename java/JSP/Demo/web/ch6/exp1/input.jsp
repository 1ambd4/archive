<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>input.jsp</title>
</head>
<body>
    <form action="recieve.jsp" method="post">
        学号： <input type="text" name="xh"><br>
        姓名： <input type="text" name="name"><br>
        出生日期： <input type="text" name="birthday"><br>
        <input type="submit", value="提交">
    </form>
</body>
</html>
