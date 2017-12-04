<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Hello.jsp' starting page</title>
    
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
     
       <!-- html注释 哈哈哈 -->
      <%--jsp注释 --%> 
            你好世界 ,北京时间:<%=new java.util.Date().toLocaleString() %>
      
      <%
         String name="jack";
         int age = 20;
       %>
       <br/>
              姓名: <%=name%>  年龄:<%=age %>  <br/>
       
              判断是否能看       <br/>
       <% if(age>=18){  %>       
                      可以看   
      <% }else{ %>  
                     你太小了,不可以看
      <% } %>  
      
      
      <!-- 定义类的成员   -->  
      <%!
        String username;
        public void dowork(){}
       %>        
              
                
            
  </body>
</html>
