<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<font size=4 color=red>这是error.jsp页面  </font>
  	<font size=2>
  	<% 
     String s=request.getParameter("mess");
     out.println("<br>输入的不是数值哦！<br>数据格式异常信息："+s);
	%>
	</font><br>
	<img src="../img/error.jpg" width="120" height="120"></img><p>
	<a href="one.jsp">返回one页面</a>
 
  </body>
</html>
