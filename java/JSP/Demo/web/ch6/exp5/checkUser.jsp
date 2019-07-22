<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>登录验证页面</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("loginName");
        String password = request.getParameter("passWord");
    %>
    你输入的用户名是： <%=name%> <br><br>

    public static Connection getConnection() {
    Connection dbConnection = null;
    try {
    Class.forName(DRIVER_CLASS);
    dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return dbConnection;
    }

    <%
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://120.79.147.108:3306/jsp?useUnicode = true&characterEncoding = utf-8";
        try {
            Connection con = DriverManager.getConnection(url, "root", "root");
            Statement stmt = null;
            stmt = con.createStatement();
            String sql = "select * from user";
            sql += "where id='" + name + "' and pwd='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                session.setAttribute("userName", name);
                response.sendRedirect("main.jsp");
            }
            else {
                out.print("无此用户或者密码输入错误，登录失败！<br><br>");
                out.print("<a href='login.jsp'>重新登录<//a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
