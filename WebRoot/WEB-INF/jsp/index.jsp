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

<title>后台管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>css/alogin.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>

<body style="background-position:center top; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="Main">
		<div class="login_input">
			<div class="input_login">
				<form action="member/login" method="post" id="loginForm">
				  <table width="300">
				    <tr height="20">
				     <td colspan="2" align="center">
				     	<span id="msg" style="color: red;font-size: 12px;"></span>
				     </td>
				    </tr>
				  	<tr>
				  	 <td align="right">登陆名:</td>
				  	 <td align="left"><input type="text" name="name" class = "t_input" id="name"></td>
				  	</tr>
				  	<tr>
				  	 <td align="right"> 密 码: </td>
				  	 <td align="left"><input type='password' name="password" class = "t_input" id="password"></td>
				  	</tr>
				  	<tr>
				  	  <td align="right"> 验证码:</td>
				  	  <td align="left"><input  type="text" name="code"  class ="t_captcha" id="checkCode">
				  	  	<img src="<%=basePath%>code" title="看不清，点击换一张" onclick="changeImg()" id = "imgObj" align="top"/>
				  	  </td>
				  	</tr>
				  	<tr align="center">
				  		<td colspan="2" ><span class="submit" id="submit"> <img alt=""src="images/btnlogin.gif" onclick="login()" /> </span></td>
				  	</tr>
				  </table>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>
