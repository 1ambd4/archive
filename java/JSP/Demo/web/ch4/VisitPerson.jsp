<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-4-9
  Time: 下午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VisitPerson</title>
</head>
<body bgcolor="#00ffff">
    <%!
        int count;
        StringBuffer person;
        public void judge() {
            if (count == 0) {
                person = new StringBuffer();
            }
        }
        public void addPerson(String p) {
            if (count == 0) {
                person.append(p);
            } else {
                person.append("," + p);
            }
            count++;
        } %>

    <%
        String name = request.getParameter("name");
        byte bb[] = name.getBytes("iso-8859-1");
        name = new String(bb, "utf-8");
        if (name == null || name.length() == 0 || name.length() > 10) {
    %>
    <jsp:forward page="InputName.jsp" />
    <%
        }
        judge();
        addPerson(name);
    %>

    <br> 目前共有 <%=count %>人访问过该站点，他们的名字是：<br>
    <font size="3"><%=person %></font>
    <p>
        <a href="InputName.jsp">返回InputName.jsp页面</a>
    </p>
</body>
</html>
