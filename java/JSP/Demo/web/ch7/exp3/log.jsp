<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
  <head>
      <script>
          function reloadImage(t) {
              t.src="../../ImageServlet?flag=" + Math.random();
          }
      </script>

    <title>My JSP 'log.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <form action="../../LogimgServlet" method="post">
        <table>
            <tr><td colspan="2" align="center">用户登录</td></tr>
            <tr>
                <td>登录名：</td>
                <input type="text" name="userName">
            </tr>
            <tr>
                <td>密码：</td>
                <input type="text" name="passWord">
            </tr>
            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" name="checkcode">
                    <img src="../../ImageServlet" align="middle" alt="看不清，点击这里" + src onclick="reloadImage(this)">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
  </body>
</html>
