<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
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
             需求:先往JSP中的四大作用域中存放共享数据,<br/>
     <%
       pageContext.setAttribute("msg", "pageContext");
       request.setAttribute("msg", "request");
       session.setAttribute("msg", "session");
        application.setAttribute("msg", "application");
     
      %>
          然后再从作用域中取出共享数据<br/>
      pageContext: <%=pageContext.getAttribute("msg")%> <br/> 
      request: <%=request.getAttribute("msg")%> <br/>  
      session: <%=session.getAttribute("msg")%> <br/>  
      application: <%=application.getAttribute("msg")%> <br/>   
        
      <hr>  
      <%-- <%=pageContext.findAttribute("msg") %> --%>  <br/>
          
          
          需求2:在页面如果有null的数据,则显示空字符串<br/>
      <%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg") %>     
      <br/>
      ${msg} <br/>
      需求:使用EL表达式从指定的作用域中获取共享数据--->使用EL的隐含对象<br/>
      ${requestScope.msg}   
  </body>
</html>
