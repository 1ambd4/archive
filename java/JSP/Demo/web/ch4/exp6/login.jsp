<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE>
<html>
  <head>
    
    <title>用户登陆界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<font size="2">
  	<form action="loginCheck.jsp" method="post">
  		用户名：<input type="text" name="userName" size="10"/>
  		密码：<input type="password" name="passWord" size="10"/><br/>&nbsp; 
  	</font>
  	<font size="1" color="green">（提交后，用户名被存入session中）<br/></font>
  	<input type="submit" value="提交"/>
  	</form>
    This is my JSP page. <br>
  </body>
</html>
