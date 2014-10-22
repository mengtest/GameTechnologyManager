<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户提问</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui-1.4/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui-1.4/themes/color.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4/locale/easyui-lang-zh-CN.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>js/question.js"></script>
  </head>
  
  <body>
    <table id="dg" class="easyui-datagrid" title="所有文章"
		style="width:100%;height:250px"
		data-options="rownumbers:true,singleSelect:true,pagination:true,collapsible:true,url:'question/getUserQuestion',method:'get',toolbar:toolbar">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id'">问题ID</th>
				<th data-options="field:'shortTitle'">问题标题</th>
				<th
					data-options="field:'createTime',align:'center',formatter:formatDate">写作时间</th>
				<th data-options="field:'name',align:'center'">作者</th>
			</tr>
		</thead>
	</table>
  </body>
</html>
