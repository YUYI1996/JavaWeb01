<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- 使用绝对或相对路径进行配置文件资源 -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<table id="dg" title="用户信息" class="easyui-datagrid" style="width:1100px;height:550px"
			url="${pageContext.request.contextPath}/UserListServlet"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">编号</th>
				<th field="firstName" width="50">昵称</th>
				<th field="lastName" width="50">名字</th>
				<th field="phone" width="50">电话號碼</th>
				<th field="email" width="50">邮箱</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增用户</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>昵称:</label>
				<input name="firstName" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>名字:</label>
				<input name="lastName" class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Phone:</label>
				<input name="phone" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Email:</label>
				<input name="email" class="easyui-textbox" validType="email">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
	</div>
	
	<script type="text/javascript">
	var url;
	function newUser(){
		$('#dlg').dialog('open').dialog('setTitle','新增用户');
		$('#fm').form('clear');
		url = '${pageContext.request.contextPath}/AddUserServlet';
	}
	
	function editUser(){
		var row = $('#dg').datagrid('getSelected');
		if (row){
			$('#dlg').dialog('open').dialog('setTitle','修改用户');
			$('#fm').form('load',row);
			url = '${pageContext.request.contextPath}/UserEditServlet?id='+row.id;
		}
	}
	
	function saveUser(){
		$('#fm').form('submit',{
			url: url,
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				var result = eval('('+result+')');
				if (result.errorMsg){
					$.messager.show({
						title: 'Error',
						msg: result.errorMsg
					});
				} else {
					$('#dlg').dialog('close');		// close the dialog
					$('#dg').datagrid('reload');	// reload the user data
				}
			}
		});
	}
	
	function destroyUser(){
		var row = $('#dg').datagrid('getSelected');
		if (row){
			$.messager.confirm('请确认','你确定要删除这个用户吗?',function(r){
				if (r){
					$.post('${pageContext.request.contextPath}/UserDeleteServlet',{id:row.id},function(result){
						if (result.success){
							$('#dg').datagrid('reload');	// reload the user data
						} else {
							$.messager.show({	// show error message
								title: 'Error',
								msg: result.errorMsg
							});
						}
					},'json');
				}
			});
		}
	}

	</script>
</body>
</html>
