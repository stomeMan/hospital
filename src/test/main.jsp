<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Full Layout - jQuery EasyUI Demo</title>
	<!--	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.4/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/jquery-easyui-1.4/demo/demo.css">
	<script type="text/javascript" src="/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.4/jquery.easyui.min.js"></script>  -->
	<link rel="stylesheet" type="text/css" href="/hospital/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="/hospital/css/icon.css">
	<link rel="stylesheet" type="text/css" href="/hospital/css/demo.css">
	<script type="text/javascript" src="/hospital/js/jquery.min.js"></script>
	<script type="text/javascript" src="/hospital/js/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">west content</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'"></div>
</body>
</html>