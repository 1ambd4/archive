<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'reqform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <form action="req_recv.jsp" method="post">
  <table border="1">
   	<tr>
   		<td>用户名：</td><td><input type="text" name="name"></td>
   	</tr>
   	<tr>
   		<td>密 码：</td><td><input type="password" name="password"></td>
   	</tr>
   	<tr>
	   	<td colspan=2 >
	   	<input type="checkbox" name="like" value="骑车" />骑自行车
	    <input type="checkbox" name="like" value="驾车" />驾驶小汽车 </td></tr>
		<tr align=center><td colspan=2 >
		<input type="submit" value="提交"> 
		<input type="reset" value="取消"></td>
	</tr>
</table>
  
  </form>
  </body>
</html>
