<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<frameset rows="60,*" cols="*" frameborder="yes" border="2"
	framespacing="0">
	<frame src="top" name="topFrame" scrolling="no">
	<frameset cols="170,*" name="btFrame" frameborder="yes"  border="2"
		framespacing="0">
		<frame src="menu" noresize name="menu" scrolling="yes">
		<frame src="content" noresize name="main" scrolling="yes">
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
