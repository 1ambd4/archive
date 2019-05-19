<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'two.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body bgcolor=yellow>
  	<font size=3 color=blue> 这是 two.jsp页面 </font>
	<font size=3>
	<%
		String s = request.getParameter("number");
 		out.println("<br>传递过来的值是" + s);
 	%>
 	</font><br>
	<img src="../img/bdlg.jpg" width="<%=s%>" height="<%=s%>"></img><p>
	<a href="one.jsp">返回one页面</a>
  </body>
</html>
