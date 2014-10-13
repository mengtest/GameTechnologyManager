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

<title>menu</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=basePath%>css/menu.css"
	type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		/* 滑动/展开 */
		$("ul.expmenu li > div.header").click(function() {

			var arrow = $(this).find("span.arrow");

			if (arrow.hasClass("up")) {
				arrow.removeClass("up");
				arrow.addClass("down");
			} else if (arrow.hasClass("down")) {
				arrow.removeClass("down");
				arrow.addClass("up");
			}

			$(this).parent().find("ul.menu").slideToggle();

		});

	});
</script>
<script language="JavaScript">
<!--//
	function ShowMenu(obj, n) {
		var Nav = obj.parentNode;
		if (!Nav.id) {
			var BName = Nav.getElementsByTagName("ol");
			var HName = Nav.getElementsByTagName("h2");
			var t = 2;
		} else {
			var BName = document.getElementById(Nav.id).getElementsByTagName(
					"span");
			var HName = document.getElementById(Nav.id).getElementsByTagName(
					".header");
			var t = 1;
		}
		for ( var i = 0; i < HName.length; i++) {
			HName[i].innerHTML = HName[i].innerHTML.replace("-", "+");
			HName[i].className = "";
		}
		obj.className = "h" + t;
		for ( var i = 0; i < BName.length; i++) {
			if (i != n) {
				BName[i].className = "no";
			}
		}
		if (BName[n].className == "no") {
			BName[n].className = "";
			obj.innerHTML = obj.innerHTML.replace("+", "-");
		} else {
			BName[n].className = "no";
			obj.className = "";
			obj.innerHTML = obj.innerHTML.replace("-", "+");
		}
	}
//-->
</script>
<style>
.menu ol {
	padding-left: 15px;
	border: #E7E7E7 1px solid;
	border-top: none;
	background: #f7f2e5;
}

.menu li i {
	background-color: #ae9c7e;
	padding: 1px 4px;
	color: #fff;
	text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);
	font-family: 宋体;
	font-style: normal;
}

.menu a {
	color: #3f3f3f;
	text-decoration: none;
}

.menu .no {
	display: none;
}

.menu ol a {
	width: 228px;
	display: block;
	line-height: 2em;
	margin-left: 20px;
}
</style>
</head>

<body>
	<ul class="expmenu">
		<li>
			<div class="header">
				<span class="label">网站管理</span> <span class="arrow up"></span>
			</div>
			 <span class="no">
				<ul class="menu" style="display:block;">
					<li onClick="javascript:ShowMenu(this,0)"><a
						href="javascript:void(0)"><i>+</i> 文章管理</a>
					</li>
					<ol class="no">
						<a href="blog/toWrite" title="发布文章" target="main">发布文章</a>
						<a href = "blog/toAllBlogs" target="main">我的文章</a>
						<a href = "blog/getAllBlogs/0/1" target="main">用户文章</a>
					</ol>
					
				</ul> 
			</span>
		</li>
		<li>
			<div class="header">
				<span class="label">游戏管理</span> <span class="arrow down"></span>
			</div>
			<ul class="menu">
				<li>查看收入</li>
			</ul>
		</li>
	</ul>
</body>
</html>
