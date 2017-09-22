<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.head-title {
	text-align: center;
}

.foot-copyright {
	text-align: center;
	line-height: 300%;
}

.admin a {
	margin-bottom: 15px;
}
</style>
<%@ include file="include.jsp"%>
<script type="text/javascript">
function addTab(title, url){
	if($('#tt').tabs('exists',title)){//判断选项卡是否存在
		$('#tt').tabs('select',title);//存在则选中该选项卡
	} else {
		$('#tt').tabs('add',{
			title: title,
			closable: true,
			content: "<iframe src='"+url+"' frameBorder='0' width='100%' height='100%' />"
		});
	}
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 80px;">
		<h1 class="head-title">xxxxx信息管理系统</h1>
	</div>
	<div data-options="region:'south'" style="height: 60px;">
		<div class="foot-copyright">&copy;版权所有 Iamrobot</div>
	</div>
	<div data-options="region:'west',title:'West',split:true"
		style="width: 200px;">
		<!-- 左边的菜单栏 -->
		<div id="aa" class="easyui-accordion"
			style="width: 193px; height: 250px;">
			<div title="用户管理" data-options="iconCls:'icon-man',selected:true"
				style="overflow: auto; padding: 10px; text-align: center;"
				class="admin">
				<a id="btnUser" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="addTab('用户管理','userManager.jsp')">用户管理</a> <a id="btnAdmin"
					href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="addTab('管理员管理','orderManager.jsp')">管理员管理</a> <a id="btnCompany"
					href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="addTab('商家管理','url')">商家管理</a>
			</div>
			<div title="订单管理" data-options="iconCls:'icon-order'"
				style="padding: 10px;">content2</div>
			<div title="Title3">content3</div>
		</div>
	</div>
	<div data-options="region:'center',title:'center title'"
		style="padding: 5px; background: #eee;">
		<!-- 选项卡 -->
		<div id="tt" class="easyui-tabs" style="width: 100%; height: 100%;">
			<div title="欢迎" style="padding: 20px; display: none;text-align:center;">
				<h2>欢迎使用本管理系统!</h2>
			</div>
		</div>
		<!-- 选项卡结束 -->
	</div>
</body>
</html>