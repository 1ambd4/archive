<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="lttzz.ch6.exp3.Car" %>
<jsp:useBean id="car" class="lttzz.ch6.exp3.Car" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="yellow">
    <table border="1">
        <tr>
            <th>汽车品牌</th><th>汽车名称</th><th>生产日期</th>
        </tr>
        <tr>
            <td><jsp:getProperty name="car" property="number"/></td>
            <td><jsp:getProperty name="car" property="name"/></td>
            <td><jsp:getProperty name="car" property="madeTime"/></td>
        </tr>
    </table>
</body>
</html>
