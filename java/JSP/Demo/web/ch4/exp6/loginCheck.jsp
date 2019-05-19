<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE>
<html>
  <head>
    
    <title>用户登录验证页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <%
  	request.setCharacterEncoding("utf-8");
  	String userName = request.getParameter("userName");
  	String passWord = request.getParameter("passWord");
  	
  	if (userName.length() > 0 && passWord.length() > 0) {
  		session.setAttribute("uname", userName);
  		response.sendRedirect("main.jsp");
  	} else {
  		response.sendRedirect("login.jsp");
  	}
  %>
    
  <body>
    This is my JSP page. <br>
  </body>
</html>
