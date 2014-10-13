<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.0.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
 	
 </script>
  </head>
  
  <body>
  <c:if test="${pageInfo.totalPages > 1}">
  <div class = "main_page">
       
    	<a href="${pageInfo.url }1"><span class ="pagecell">首页</span></a><a href="${pageInfo.url}${pageInfo.nowPage - 1}" ><span class = "pagecell">上一页</span></a>
    	<c:forEach var="num" begin="${pageInfo.start}" end="${pageInfo.end}">
    	
    	
    	<c:choose>
    		<c:when test="${num == pageInfo.nowPage}">
    		<a href="${pageInfo.url }${num }"><span class="pagecellNum" style="background-color: #FFCCCC;">${ num }</span> </a>
    		</c:when>
    		<c:otherwise>
    			<a href="${pageInfo.url }${num}"><span class="pagecellNum">${ num }</span> </a>
    		</c:otherwise>
    	</c:choose>
    	
    	</c:forEach>
    	
    	<a href= "${pageInfo.url}${pageInfo.nowPage + 1}"><span class ="pagecell">下一页</span></a><a href = "${ pageInfo.url}${pageInfo.totalPages }"><span class ="pagecell">尾页</span></a><span class ="pagecellEnd">共  ${pageInfo.totalPages } 页</span>
    </div>
    </c:if>
    </body>
</html>
