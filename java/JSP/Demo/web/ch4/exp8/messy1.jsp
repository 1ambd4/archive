<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
  <head>
    
    <title>URL传递参数中文处理实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <%
  	String param = request.getParameter("param");
  %>
  
  <body>
  	<a href="messy1.jsp?param='中文'">请点击这个链接</a><br/>
  	你提交的参数是：<%=param %>
  </body>
</html>
