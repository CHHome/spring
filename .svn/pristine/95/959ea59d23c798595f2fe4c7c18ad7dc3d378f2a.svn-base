<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	var baseUrl = '${pageContext.request.contextPath }/user/';
	$(function() {
		$('#dg').datagrid({
			url : baseUrl + 'page.do',//请求的URL
			pagination : true, //显示分页工具栏
			rownumbers : true
		//请求的行号
		});

		$('#dg').datagrid("getPager").pagination({//获取分页组件
			onSelectPage : function(pageNumber, pageSize) {
				reload(pageNumber, pageSize);
			}
		});
		//定义表单提交
		$('#ff').form('submit', {    
		    url: baseUrl + "edit.do",    
		    onSubmit: function(){ //提交表单之前执行的方法,如果返回false,则不提交表单   
 		       return $('#ff').form("validate");    
		    },    
		    success:function(data){    
		        var json = JSON.parse(data);
		        alert(json.msg);
		        $('#ff').form("clear");
		    }    
		}); 
	})
	function reload(pageNumber, pageSize) {
		$('#dg').datagrid("reload", {
			pageNumber : pageNumber,
			pageSize : pageSize
		});
	}
	function delFmt(value, row, index) {
		return "<a href='javascript:void(0)' onclick='del(" + row.id
				+ ")'>删除</a>";
	}
	function updateFmt(value, row, index) {
		return "<a href='javascript:void(0)' onclick='edit(" + index
				+ ")'>修改</a>";
	}

	//删除指定ID的记录
	function del(id) {
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.ajax({
					url : baseUrl + "del.do",
					data : {
						id : id
					},
					dataType : "json",
					success : function(data) {
						$.messager.alert('删除', data.msg);
						$('#dg').datagrid("reload");
					}
				});
			}
		});
	}
	//修改指定的记录
	function edit(index) {
		$('#ff').form("clear");
		//获取指定的需要修改的数据
		var data = $('#dg').datagrid("getData")["rows"][index];
		$('#ff').form('load',data);
		//显示修改的对话框
		$('#dd').dialog({
			closed : false
		});
	}
	//提交表单
	function doSubmit(){
		$('#ff').form("submit");
	}
	//自定义验证规则
	$.extend($.fn.validatebox.defaults.rules, {    
	    samePwd: { //定义方法名称   
	        validator: function(value, id){//value是当前文本框的值, id是指定进行比较的文本框的ID    
	            return value == $(id[0]).val();    
	        },    
	        message: '密码和确认密码不一致'   
	    }    
	});  

</script>
</head>
<body>
	<table class="easyui-datagrid" id="dg">
		<thead>
			<tr>
				<th data-options="colspan:4">数据</th>
				<th data-options="colspan:2">操作</th>
			</tr>
			<tr>
				<th data-options="field:'id'">ID</th>
				<th data-options="field:'username'">用户名</th>
				<th data-options="field:'password'">密码</th>
				<th data-options="field:'icon'">头像</th>
				<th data-options="field:'del',formatter:delFmt">删除</th>
				<th data-options="field:'mod',formatter:updateFmt">修改</th>
			</tr>
		</thead>
	</table>
	<!-- 修改和添加的对话框窗口 -->
	<div id="dd" class="easyui-dialog" title="编辑"
		style="width: 500px; height: 400px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

		<form id="ff" method="post">
			<div><input type="hidden" name="id" /></div>
			<div>
				<label for="name">用户名</label><input class="easyui-validatebox"
					type="text" name="username" required validType="length[4,8]" />
			</div>
			<div>
				<label for="pwd">密码</label> <input class="easyui-validatebox"
					type="text" id="pwd" name="password" validType="length[5,10]" required />
			</div>
			<div>
				<label for="email">确认密码</label> <input class="easyui-validatebox"
					type="text" id="confirm" validType="samePwd['#pwd']" />
			</div>
			<div><input type="button" onclick="doSubmit()" value="提交" /></div>
		</form>

	</div>


</body>
</html>