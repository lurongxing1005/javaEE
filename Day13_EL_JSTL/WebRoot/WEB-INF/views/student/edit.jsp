<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
     <h2>${stu==null?"新增":"修改"}学生</h2>
     <form action="${pageContext.request.contextPath}/student?cmd=saveOrUpdate" method="post">
     <input type="hidden" name="id" value="${stu.id}">
                  姓名:<input type="text" name="name"  value="${stu.name}"><br/><br/>
                  年龄:<input type="number" name="age" max="100" min="1" value="${stu.age}"><br/><br/>
      <input type="submit" value='${stu==null?"新增":"修改"}'>
     </form>
  </body>
</html>
