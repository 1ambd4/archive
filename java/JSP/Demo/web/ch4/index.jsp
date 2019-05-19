<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-4-14
  Time: 下午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        function $(id) {
            return document.getElementById(id)
        }
        function clear() {
            document.getElementById("user").value="";
            document.getElementById("passwd").value="";
            alert("已清空")
            return true;
        }
        function check() {
            var user = $("user").value;
            var passwd = $("passwd").value;

            if (user == "admin" || passwd == "password") {
                alert("欢迎登录")
                return true;
            } else {
                alert("用户名或者密码错误")
                clear();
                return false;
            }
        }
    </script>
</head>
<body bgcolor="#00ffff">
<form>
    <fieldset>
        <legend align="center">用户登录</legend>
        <label>用户名：</label>
        <input type="text" id="user"><br><br>
        <label>密&nbsp&nbsp&nbsp&nbsp码：</label>
        <input type="password" id="passwd"><br>
        <div text-align:center;>
            <input type="button" value="登录" onclick="check()">
        </div>
    </fieldset>
</form>text-align:center;
</body>
</html>