<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="lttzz.ch4.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'exp3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<%
  		Student[] stu = { new Student("001", "欧巴马", "13844488101"),
  						  new Student("002", "李刚好", "13848888108"),
						  new Student("003", "胡规范", "18844488158") };
		
		List lstu = new ArrayList();
		lstu.add(new Student("001", "欧巴马", "13844488101"));
		lstu.add(new Student("002", "李刚好", "13848888108"));
		lstu.add(new Student("003", "胡规范", "18844488158"));
		
		Map mstu = new HashMap();
		mstu.put("A011", new Student("001", "欧巴马", "13844488101"));
		mstu.put("A012", new Student("002", "李刚好", "13848888108"));
		mstu.put("A013", new Student("003", "胡规范", "18844488158"));
  	%>
  	
  	从数组中取出数据放入表格中
  	<table border="1" bgcolor="#aa8899">
  		<tr>
  			<td>学号</td><td>姓名</td><td>联系电话</td>
  		</tr>
  		<%
  			for(int i = 0; i < stu.length; ++i) {
  		%>
  		<tr>
  			<td><%=stu[i].getXh()%></td>
  			<td><%=stu[i].getName()%></td>
  			<td><%=stu[i].getTeleno()%></td>
  		</tr>
  		<%
  			}
  		%>
  	</table>
  	
  	<br>从List中取出数据放入表格中
  	<table border="1" bgcolor="#ddaa99">
  		<tr>
  			<td>学号</td><td>姓名</td><td>联系电话</td>
  		</tr>
  		<%
  			for (int i = 0; i < lstu.size(); ++i) {
  		%>
  		<tr>
  			<td><%=((Student)lstu.get(i)).getXh()%></td>
  			<td><%=((Student)lstu.get(i)).getName()%></td>
  			<td><%=((Student)lstu.get(i)).getTeleno()%></td>
  		</tr>
  		<%
  			}
  		%>
  	</table>
  	
  	<br>从List中取出数据放入表格[学号带超链]
  	<table border="1" bgcolor="#aaff77">
  		<tr>
  			<td>学号</td><td>姓名</td><td>联系电话</td>
  			<%
  				for (int i = 0; i < lstu.size(); ++i) {
  			%>
  			<tr>
  				<td>
  					<a href=detail.jsp?xh=<%=((Student) lstu.get(i)).getXh()%> >
  					<%=((Student) lstu.get(i)).getXh()%></a>
  				</td>
  				<td><%=((Student)lstu.get(i)).getName()%></td>
  				<td><%=((Student)lstu.get(i)).getTeleno()%></td>
  			</tr>
  			<%
  				}
  			%>
  		</tr>
  	</table>
  	
  	<br>从Map中获取数据
  	<table border="1" bgcolor="#aaff88">
  		<tr>
  			<td>学号</td><td>姓名</td><td>联系电话</td>
  		</tr>
  		<%
  			Set xhSet = mstu.keySet();
  			Object[] xh_a = xhSet.toArray();
  			Student ss = new Student();
  			for(int i = 0; i < xh_a.length; ++i) {
  				ss = (Student)mstu.get((String)xh_a[i]);
  		%>
  		<tr>
  			<td><%=ss.getXh()%></td>
  			<td><%=ss.getName()%></td>
  			<td><%=ss.getTeleno()%></td>
  		</tr>
  		<%
  			}
  		%>
  	</table>
  </body>
</html>
