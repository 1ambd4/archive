<%--
  Created by IntelliJ IDEA.
  User: lttzz
  Date: 19-6-10
  Time: 上午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body bgcolor="#ffffff" text="#000000" leftmargin="0" topmargin="40" marginwidth="0" marginheight="0">
    <center><h1>文件上传</h1></center>
    <form name="uploadform" method="post"  action="../../FileUploadServlet" enctype="multipart/form-data">
        <table border="1" width="450" cellpadding="4" cellspacing="2">
            <tr>
                <td colspan="2">
                    文件1:<input type="file" name="file1" size="40">
                </td>
            </tr>
            <tr>
               <td colspan="2">
                   文件2:<input type="file" name="file2" size="40">
               </td>
            </tr>
            <tr>
                <td colspan="2">
                    文件3:<input type="file" name="file3" size="40">
                </td>
            </tr>
        </table><br><br>
        <table>
            <tr>
                <td align="center">
                    <input type="submit" name="submit" value="开始上传">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
