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
    
    <title>My JSP 'foreach.jsp' starting page</title>
    
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
        List list = new ArrayList();
        list.add("JavaSE");
        list.add("JavaEE");
        list.add("JavaME");
        request.setAttribute("list", list);
       %>
       <c:forEach items="${list}" var="item" varStatus="vs">
         ${vs.count} ----- ${item}<br/>
       </c:forEach>
       
       <!--  打印  1,2,3,4,5,6,7...  -->
       <c:forEach var="num" begin="1" end="10" step="2">
         ${num}
       </c:forEach>
       
  </body>
</html>
