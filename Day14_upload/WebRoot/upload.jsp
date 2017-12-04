<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h2>注册</h2>
   <span style="color:red;">${errorMsg}</span>
   <form action="/Day14_upload/uploadAnno"  method="post" enctype="multipart/form-data">  <!--  -->
           用户名:<input type="text" name="username"><br/><br/>
           密码:<input type="password" name="password"><br/><br/>
           头像:<input type="file" name="headImg"><br/><br/>
           头像2:<input type="file" name="headImg2"><br/><br/>
       <input type="submit" value="朕要注册">    
   </form>
  </body>
</html>
