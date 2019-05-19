<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'request.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<font size="2">
  	request主要方法调用示例：<br/>
  	<%
  		request.setAttribute("attr", "Hello!");
  		out.println("attr属性的值为：" + request.getAttribute("attr") + "<br>");
  		out.println("上下文路径为：" + request.getContextPath() + "<br>");
  		out.println("Cookies：" + request.getCookies() + "<br>");
  		out.println("Host:" + request.getHeader("Host") + "<br>");
  		out.println("ServerName：" + request.getServerName() + "<br>");
  		out.println("ServerPort：" + request.getServerPort() + "<br>");
  		out.println("RemoteAddr：" + request.getRemoteAddr() + "<br>");
  		request.removeAttribute("attr");
  		out.println("属性移除操作以后attr属性的值为："+request.getAttribute("attr")+"<br>");  
  		out.println("WEB项目的物理路径："+this.getServletContext().getRealPath("") +"<br>"); 
  	%>
  	</font>
  </body>
</html>
