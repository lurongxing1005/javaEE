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
    
    <title>商品信息</title>
    
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
    <h2>商品信息管理</h2>
     <form action="/Day15_Query/product" method="post">
               商品名称:<input type="text" name="productName"  value="${op.productName}">
               价格:<input type="text" name="minPrice" value="${op.minPrice}">
     --
     <input type="text" name="maxPrice" value="${op.maxPrice}">
         商品分类：<select name="dir_id">
          <option value="-1">--请选择--</option>
         <c:forEach items="${dirs}" var="dir">
            <option value="${dir.id}" ${op.dir_id==dir.id?"selected='selected'":""}>${dir.dirName}</option>
         </c:forEach>
      
      </select>
      <input type="submit" value="查询">
     </form>
    <table border="1" width="75%" cellspacing="0" cellpadding="0">
      <tr style="background-color: orange">
         <th>商品编号</th>
         <th>商&nbsp;品&nbsp;名&nbsp;称</th>
         <th>商品品牌</th>
         <th>商品分类</th>
         <th>供&nbsp;应&nbsp;商</th>
         <th>零&nbsp;售&nbsp;价</th>
         <th>成&nbsp;本&nbsp;价</th>
         <th>折&nbsp;&nbsp;扣</th>
      </tr>
      
      <c:forEach items="${list}" var="po" varStatus="vs">
        <tr style="background-color: ${vs.count%2==0?'pink':''}">
         <td>${po.id}</td>
         <td>${po.productName}</td>
         <td>${po.brand}</td>
         <td>
            <c:choose>
              <c:when test="${po.dir_id==2}">无线鼠标</c:when>
              <c:when test="${po.dir_id==3}">有线鼠标</c:when>
              <c:when test="${po.dir_id==4}">游戏鼠标</c:when>
            </c:choose>
         </td>
         <td>${po.supplier}</td>
         <td>${po.salePrice}</td>
         <td>${po.costPrice}</td>
         <td>${po.cutoff}</td>
         
        
       </tr>
      
      </c:forEach>
      
      
       
    
    </table>
  </body>
</html>
