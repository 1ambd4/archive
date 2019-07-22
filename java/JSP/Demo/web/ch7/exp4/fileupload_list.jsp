<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 2019/6/30
  Time: 上午6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileupload_list</title>
</head>
<body>
    <font size="4" color="red">已经上传的文件</font><br>
    <font size="5" color="blue">
        <%
            String path = "/home/lttzz/test/tmp";
            File fl = new File(path);
            File[] filelist = fl.listFiles();
            out.println("文件上传的保存路径" + path + "<br><br>");

            for (int i = 0; i < filelist.length; ++i) {
                out.println((i + 1) + ":" + filelist[i].getName() + "&nbsp;&nbsp;<br>");
                out.println("<img scrc=images\\" + filelist[i].getName() + "><br><br>");
            }
        %>
</body>
</html>
