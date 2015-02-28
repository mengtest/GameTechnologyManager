<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

		<title>游戏技术网-写博客</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/common.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/base.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/blog.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>js/jquery-easyui-1.4/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>js/jquery-easyui-1.4/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>js/jquery-easyui-1.4/themes/color.css">
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.0.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-easyui-1.4/jquery.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=basePath%>js/ueditor1_4_3/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=basePath%>js/ueditor1_4_3/ueditor.all.min.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=basePath%>js/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/blog.js"></script>
		<!-- 实例化编辑器 -->
		<script type="text/javascript">
	var ue = UE.getEditor('container', {
		initialFrameHeight : 870,
		initialFrameWidth : 800,
		maximumWords : 35000
	});
</script>
	</head>

	<body>
		<div class="main_div_write_blog">
			<form action="<%=basePath%>blog/publish" method="post"
				name="submitForm">
				<input type="hidden" value="${blog.id }" name="id" />
				<input type="hidden" value="${token }" name = "token"/>
				<table width="800">
					<tr>
						<td height="50">
							<span style="color: olive; font-size: 14px; height: 40px;">文章标题</span>
							<hr />
							<input type="text" name="title" id="title" value="${blog.title }"
								style="width: 800px; height: 28px;" />
						</td>
					</tr>

					<tr>
						<td>
							<!-- 加载编辑器的容器 -->
							<script id="container" name="content" type="text/plain">${blog.content }</script>
						</td>
					</tr>
					<tr align="left">
						<td>
							<select name="classifyId" id="classifyId">
								<option value="-1" selected="selected">
									文章分类
								</option>
								<c:forEach items="${classify}" var="item">
									<c:choose>
										<c:when test="${blog.classifyId == item.id}">
											<option value="${item.id }" selected="selected">
												${item.name }
											</option>
										</c:when>
										<c:otherwise>
											<option value="${item.id }">
												${item.name }
											</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</td>
					</tr>

					<tr>
						<td>
							<hr style="border: 1px dotted #FFCCCC;" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" name="publish" value="发表文章" id="publish" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
