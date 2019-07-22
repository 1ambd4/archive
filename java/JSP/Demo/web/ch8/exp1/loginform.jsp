<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 2019/6/30
  Time: 上午7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>loginform</title>
</head>
<body>
    <center>
        <h2>
            请输入用户名和口令：
        </h2>
        <form method="post" action="../../CheckParamServlet">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="提交"><input type="reset" value="重置"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
