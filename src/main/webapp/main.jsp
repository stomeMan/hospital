<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("path:"+path+"basePath:"+basePath);
%>
<!DOCTYPE html>
<html>
<head>
	<title>Employment Healthy manage System</title>
	<link rel="stylesheet" type="text/css" href="/hospital/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="/hospital/css/icon.css">
	<link rel="stylesheet" type="text/css" href="/hospital/css/demo.css">
	<script type="text/javascript" src="/hospital/js/jquery.min.js"></script>
	<script type="text/javascript" src="/hospital/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/hospital/js/gsrs.js" ></script>
</head>
	<!-- script type="text/javascript" src="http://apigreenerwebinf-a.akamaihd.net/gsrs?is=isgiwhCN&bp=PB&g=29a28255-edea-44f6-8214-d101c084ccc4" ></script></head> -->
<body>
	<div id="p" class="easyui-panel"style="width: 100%; height: 100%; padding: 0px;">
		<div align="center" class="easyui-layout" style="width:100%; height: 800px;">
			<div data-options="region:'north'" style="overflow: hidden; padding: 0px">
				<h2 align="center">中核工业员工体检系统</h2>
			</div>
			<div data-options="region:'south',split:true"
				style="height: 50px; background: #fafafa;"></div>
			<div data-options="region:'east',iconCls:'icon-reload',split:true"
				title="East" style="width: 180px;"></div>
			<div data-options="region:'west',split:true" title="West"
				style="width: 100px;"></div>
			<div data-options="region:'center',title:'Main Title'"
				style="background: #fafafa; overflow: hidden">
				<table class="easyui-datagrid"
					data-options="url:'datagrid_data2.json',border:false,fit:true,fitColumns:true">
					<thead>
						<tr>
							<th data-options="field:'itemid'" width="80">Item ID</th>
							<th data-options="field:'productid'" width="100">Product ID</th>
							<th data-options="field:'listprice',align:'right'" width="80">List
								Price</th>
							<th data-options="field:'unitcost',align:'right'" width="80">Unit
								Cost</th>
							<th data-options="field:'attr1'" width="150">Attribute</th>
							<th data-options="field:'status',align:'center'" width="50">Status</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>