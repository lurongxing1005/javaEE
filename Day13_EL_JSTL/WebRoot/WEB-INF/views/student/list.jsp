<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学习管理系统</title>
    
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
    <h2>学生管理</h2>
    <a href="${pageContext.request.contextPath}/student?cmd=edit">新增学生</a>
    <table border="1" width="60%" cellspacing="0" cellpadding="0">
      <tr style="background-color: orange">
         <th>编号</th>
         <th>姓名</th>
         <th>年龄</th>
         <th>操作</th>
      </tr>
      
      <c:forEach items="${list}" var="stu" varStatus="vs">
        <tr style="background-color: ${vs.count%2==0?'pink':''}">
         <td>${stu.id}</td>
         <td>${stu.name}</td>
         <td>${stu.age}</td>
         <td><a href="${pageContext.request.contextPath}/student?cmd=delete&id=${stu.id}">删除</a>
         |<a href="${pageContext.request.contextPath}/student?cmd=edit&id=${stu.id}">编辑</a></td>
       </tr>
      
      </c:forEach>
      
      
       
    
    </table>
    
  </body>
</html>
