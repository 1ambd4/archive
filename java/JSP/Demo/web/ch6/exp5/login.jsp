<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-2
  Time: 下午6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.sql.*"%>
<html>
<head>
    <title>登录程序实验</title>
</head>
<body>
    <table align="center">
        <tr>
            <td align="center">
                <p><font  color="#663399" size="5" style="font-family: 'Noto Sans ImpAramaic'"></font> </p>
                <form method="post" action="checkUser.jsp" target="_blank">
                    <p>用户名： <input type="text" name="loginName", size="20" ></p>
                    <p>密码：<input type="password", name="passWord", size="20"></p>
                    <input type="submit" value="提交">
                    <input type="reset" value="重置">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
