<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>Spring 3.0 MVC demo</title>
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
		<div>
			<form id="form_login" action="user/toMain.action" method="post">
				<label> 用 户 ID: <input id="username" name="username" size="15" type="text" /></label>
				 <label>密 码 : <input id="password" name="password" size="15" type="password" /></label>
				 <label> <input type="submit" value="登陆"/></label>
			</form>
		</div>
	<!-- jsp:include page="jquery-easyui-1.4/main.html" flush="" /> -->
</body>
</html>
