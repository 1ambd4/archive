<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<%
  		String xh = request.getParameter("xh");
  		byte[] bytes = xh.getBytes("ISO-8859-1");
  		xh = new String(bytes, "utf-8");
  	%>
  	学号为 <font size=4 color="red"><%=xh%></font> 同学的详细信息如下<br>
  	<img src=../img/<%=xh%>.jpg>
  </body>
</html>
