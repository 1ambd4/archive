<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="car" class="lttzz.ch6.exp2.Car" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#90ee90">
    <font size="4">
        <form action="" method="post">
            汽车品牌： <input type="text" name="number">
            汽车名称： <input type="text" name="name">
            生产日期： <input type="text" name="madeTime">
            <input type="submit" value="提交">
        </form>
        <jsp:setProperty name="car" property="*" />
        <table border="1">
            <tr>
                <th>汽车品牌</th>
                <th>汽车名称</th>
                <th>生产日期</th>
            </tr>
            <tr>
                <td><jsp:getProperty name="car" property="number"/></td>
                <td><jsp:getProperty name="car" property="name"/></td>
                <td><jsp:getProperty name="car" property="madeTime"/></td>
            </tr>
        </table>
    </font>
</body>
</html>
