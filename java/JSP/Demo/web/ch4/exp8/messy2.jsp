<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
  <head>
    
    <title>Form中文处理实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <% request.setCharacterEncoding("utf-8"); %>
  <font size="2">
  下面是表单提交的内容：
  <form action="messy2.jsp" method="post">
  	用户名：<input type="text" name="userName" size="10"/>
  	密码：<input type="password" name="pssWord" size="10"/>
  	<input type="submit" value="提交"/>
  </form>
  </font><br>
  
  <font size="2">
  下面是表单提交以后用于request取得取到的表单数据：<br/>
  <%
  	String userName = request.getParameter("userName");
  	String passWord = request.getParameter("passWord");
  	
  	if (null != userName) {
  		out.print("表单输入Username的值 = " + userName + "<br>");
  		out.print("表单输入Password的值 = " + passWord + "<br>");
  	} else {
  		out.print("表单参数尚为提交");
  	}
  %>
  </font>
  </body>
</html>
