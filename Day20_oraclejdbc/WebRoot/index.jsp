<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
	  $("#_btn").click(function(){
	     
	     $.get("/Day20_oraclejdbc/deptServlet",function(data,status){
	        if(status == "success"){
	           //alert(data);
	           var info="";
	           console.debug(data);
	            $.each(data,function(index,dept){
	              info+=dept.lOC+","+dept.dEPTNO+","+dept.dNAME+"<br>";
	             // info += index;
	           });
	           $("#_dept").html(info); 
	        }
	     
	     });
	  });
	  
	});
	
	
	</script>
  </head>
  
  <body>
      <div id="_dept"></div>
      <input type="button" value="获取部门信息" id="_btn">
  </body>
</html>
