<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="lttzz.ch6.exp3.Car" %>
<jsp:useBean id="car" class="lttzz.ch6.exp3.Car" scope="request" />
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#ffffe0">
    <form action="show.jsp" method="post">
        汽车品牌： <input type="text" name="number">
        汽车名称： <input type="text" name="name">
        生产日期： <input type="text" name="madeTime">
        <input type="submit" value="提交">
    </form>
    <jsp:setProperty name="car" property="*" />
    <a href="show.jsp">访问show.jsp查看</a>
</body>
</html>
