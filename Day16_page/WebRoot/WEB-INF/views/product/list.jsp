<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
	<script type="text/javascript">
	
	//设置页面大小
	   function setPageSize(currentPage){
	     var pageSize =document.getElementById("selectPageSize").value;
	        //将当前页面的值 存放在高级查询表单隐藏域中
	     document.getElementById("pageSizeInput").value=pageSize;
	     document.getElementById("currentPageInput").value=currentPage;
	      //提交高级查询的表单
	     document.getElementById("advanceFrom").submit();
	       
	      
	   } 
	   
	   function goPage(currentPage,pageSize){
	      
	      //将当前页面的值 存放在高级查询表单隐藏域中
	      document.getElementById("currentPageInput").value=currentPage;
	      document.getElementById("pageSizeInput").value=pageSize;
	      //提交高级查询的表单
	      document.getElementById("advanceFrom").submit();
	   }
	   
	   function setCurrentPage(pageSize){
	     var currentPage = document.getElementById("jumpPage").value;
	    //将当前页面的值 存放在高级查询表单隐藏域中
	      document.getElementById("currentPageInput").value=currentPage;
	      document.getElementById("pageSizeInput").value=pageSize;
	      //提交高级查询的表单
	      document.getElementById("advanceFrom").submit();
	   }
	</script>

  </head>
  
  <body>
    <h2>商品信息管理</h2>
    <h4>欢迎:【${sessionScope.USER_IN_SESSION.username }】   登录 
    <a href="/Day16_page/logout">注销</a></h4>
     
     <a href="#">添加商品</a>
     <form action="/Day16_page/product" method="post"  id="advanceFrom">
     <input type="hidden"  name="currentPage" id="currentPageInput">
     <input type="hidden"  name="pageSize" id="pageSizeInput">
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
      
      <c:forEach items="${pageResult.listData}" var="po" varStatus="vs">
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
    <!--分页开始  -->
    <div>
                 一共${pageResult.totalCount}条数据
               当前页${pageResult.currentPage}/${pageResult.totalPage}           
      <a href="javascript:goPage(1,${pageResult.pageSize})">首页</a> 
      <a href="javascript:goPage(${pageResult.prePage},${pageResult.pageSize})">上一页</a> 
      
      <c:forEach begin="${pageResult.index.beginIndex}" 
      end="${pageResult.index.endIndex}" var="index">
      
      <c:if test="${index==pageResult.currentPage}">
         <span style="color:red;">${index}</span>
      </c:if>
      <c:if test="${index!=pageResult.currentPage}">
         <a href="javascript:goPage(${index},${pageResult.pageSize})">${index}</a>
      </c:if>
      
      
         
      </c:forEach>
      
      
        
      <a href="javascript:goPage(${pageResult.nextPage},${pageResult.pageSize})">下一页</a>   
      <a href="javascript:goPage(${pageResult.totalPage},${pageResult.pageSize})">尾页</a>             
      <form action="/Day16_page/product" id="pageSizeForm"  method="post">
         每页显示： <select name="pageSize" id="selectPageSize" onchange="setPageSize(${pageResult.currentPage});" >
            <option ${pageResult.pageSize==3?"selected='selected'":""}>3</option>
            <option ${pageResult.pageSize==5?"selected='selected'":""}>5</option>
            <option ${pageResult.pageSize==8?"selected='selected'":""}>8</option>
            <option ${pageResult.pageSize==10?"selected='selected'":""}>10</option>
         </select>
          条数据
          <br/>
              跳转到第<input type="number" id="jumpPage" name="currentPage" min="1" max="${pageResult.totalPage}" value="${pageResult.currentPage}">页
        <!-- <input type="submit" value="GO" > -->
        <input type="button" value="GO" onclick="setCurrentPage(${pageResult.pageSize});">
       
      </form>
    </div>
    <!--分页结束  -->
  </body>
</html>
