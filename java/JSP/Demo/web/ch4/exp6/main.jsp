<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>

<!DOCTYPE>
<html>
  <head>
    <title>系统主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<font size="2">
  	
  	<%
  		String uname = (String)session.getAttribute("uname");
  		if (uname != null) {
  			out.print("登陆成功，欢迎 " + uname + "浏览站点");
  		} else {
  			response.sendRedirect("login.jsp");
  		}
  	%>
  	<font size="1" color="green">上述名字<%=uname %> 是从session中取出的。</font>
  	</font> 
  </body>
</html>
