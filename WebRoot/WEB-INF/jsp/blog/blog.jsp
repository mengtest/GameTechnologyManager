<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>博客共用</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"
			src="<%=basePath%>js/editor/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/blog.js"></script>
  </head>
  
  <body>
				<table width="850" class = "showblog">
						<tr height="30px;">
						<td align="left"><h2><span>&nbsp;&nbsp;${blog.title }</span></h2></td>
						</tr>
						<tr>
						<td align="right" style="font-size: 12px;color: gray;">
						<span>作者:${blog.name }</span>&nbsp;&nbsp;
						<span>阅读次数:${blog.readTimes }</span> &nbsp;&nbsp;
						<span>
						<fmt:formatDate value="${blog.createTime}" type="both"/>
						
						</span>
						
						</td>
						</tr>
						<tr>
							<td>
							<h4>摘要：</h4>
							${blog.shortContent }
							</td>
						</tr>
						<tr>
						<td>&nbsp;&nbsp;<span style="font-size: 14px;line-height: 22px;">${blog.content }</span></td>
						</tr>
				</table>
  </body>
</html>
