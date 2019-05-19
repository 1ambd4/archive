<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head> 
    <title>My JSP 'req_recv.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <%
  	request.setCharacterEncoding("utf-8");
	String parameterName=null;
	String[] parameterValue=null;
  %>
  <p>使用request.getParameter("name")取得的值：
  <% out.println(request.getParameter("name"));  %>
  <p>使用request.getParameterNames()取得表单所有参数的值:<br>
  <%
  	Enumeration en = request.getParameterNames();
	int j=0;
	while(en.hasMoreElements()){
	parameterName =(String) en.nextElement();
	parameterValue = request.getParameterValues(parameterName);
	out.println("表单参数名称:"+parameterName+"=");
  %>
  <%  //逐个输出该表单参数的值
  	for(int i=0;i<parameterValue.length;i++){
  %>
 <%=parameterValue[i]%>
 <% } %>  <br>
 <%}%>
  </body>
</html>
