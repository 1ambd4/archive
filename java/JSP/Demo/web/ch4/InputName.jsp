<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-4-9
  Time: 下午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InputName</title>
</head>
<body bgcolor="#00ffff">
    <font size="3">
        <from action="VisitPerson.jsp" method="get">
            请输入姓名：
            <input type="text" name="name" ><br>
            <input type="submit" value="加入到访问者行列" >
        </from>
    </font>
</body>
</html>
