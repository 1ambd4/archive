<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
  <head>
    
    <title>利用application对象实现的计数器实例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <font size="2">
  <%
  	int count = 0;
  	if (application.getAttribute("count") == null) {
  		count++;
  		application.setAttribute("count", count);
  	} else {
  		count = Integer.parseInt(application.getAttribute("count").toString());
  		count++;
  		application.setAttribute("count", count);
  	}
  	
  	out.print("您是本网站的第" + count + "位访问者。");
  %>
  </font>
  </body>
</html>
