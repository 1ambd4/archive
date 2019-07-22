<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="st" class="lttzz.ch6.exp1.Student" scope="request" />
<html>
<head>
    <title>JavaBean test</title>
</head>
<body>
    <% request.setCharacterEncoding("utf-8"); %>
    直接从表单自动获取到的参数如下：<br>
    <jsp:setProperty name="st" property="*" />
        学号： <%=st.getXh()%> <br>
        姓名： <%=st.getName()%> <br>
        出生日期： <%=st.getBirthday()%> <br>
    通过request.getParameter()获取到的表单参数如下：<br>
        学号： <%=request.getParameter("xh")%> <br>
        姓名： <%=request.getParameter("name")%> <br>
        出生日期： <%=request.getParameter("birthday")%> <br>
</body>
</html>
