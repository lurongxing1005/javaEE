<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstl.jsp' starting page</title>
    
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
      <%
        Integer age=18;
        request.setAttribute("age", age);
       %> 
        <c:if test="${age>=18}">
                              大于18
        </c:if> 
        <br/>
       <%--  <c:if test="${age<=18}" var="ret"></c:if>        
        ${ret} --%>
        <br/>
        <c:if test="${age>18}" var="ret1" scope="page"></c:if> 
        <c:if test="${age==18}" var="ret1" scope="request"></c:if>        
        ${ret1}
        ${requestScope.ret1}
        
        <!--if---else if----else if  -->
        
        <%
          int score = 58;
          request.setAttribute("score", score);
         %>
         <c:choose>
            <c:when test="${score>90}">优秀</c:when>
            <c:when test="${score<90&&score>60}">合格</c:when>
            
            <c:otherwise>不及格</c:otherwise>
         
         </c:choose>
       
  </body>
</html>
