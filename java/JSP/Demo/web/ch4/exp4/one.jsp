<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  	<jsp:include page="head.txt"/>
    <title>My JSP 'one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body bgcolor=yellow>
  	<form action="" method=get name=form>
  		请输入1至100之间的整数<br> 
        1~50 转two.jsp、51~100 转two.jsp。<br>
                     并且显示图片，图片大小与输入的数值一致。<br>
        (输入非数字则转error.jsp)：<p>
        <input type="text" name="number"/>
        <input type="submit" value="送出" name=submit/>
  	</form>
  	
  	<%
  		String num = request.getParameter("number");
  		if (num == null) { num = "0"; }
  		try { int n = Integer.parseInt(num);
  			if (n >= 1 && n <= 50) {
  	%>
  	<jsp:forward page="two.jsp">
  		<jsp:param name="number" value="<%=n%>"/>
  	</jsp:forward>
  	<%
  			} else if (n > 50 && n <= 100) {
  	%>
  	<jsp:forward page="three.jsp">
  		<jsp:param name="number" value="<%=n%>"/>
  	</jsp:forward>
  	<%
  			}}
  		catch(Exception e) {
  	%>
  	<jsp:forward page="error.jsp">
  		<jsp:param name="mess" value="<%=e.toString()%>"/>
  	</jsp:forward>
  	<%
  		}
  	%>
  </body>
</html>
