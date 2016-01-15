<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>用户列表</title>
<script type="text/javascript">

function deleteRecord(){
	var url="user_deleteSelected";
    document.form.action=url;  
    document.form.submit();
}

function CheckSelect(thisform) {
	// 遍历 form
	for (var i = 0; i < thisform.elements.length; i++) {
		// 提取控件
		var checkbox = thisform.elements[i];
		// 检查是否是指定的控件
		if (checkbox.name == "ids" && checkbox.type == "checkbox" && checkbox.checked == false) {
			// 正选
			checkbox.checked = true;
		} else if (checkbox.name == "ids" && checkbox.type == "checkbox" && checkbox.checked == true) {
			// 反选
			checkbox.checked = false;
		}
	}
}
</script>
</head>
<body>
	<center>
    	<h2>用户列表</h2>
    	<h3><s:a action="user_addUI" namespace="/user">添加新用户</s:a> </h3>
    	<h3><s:a action="file_fileUploadUI" namespace="/file">文件上传</s:a> </h3>
    	<s:form name="form" method="port" namespace="/user">
    	<input type="button" onclick ="javascript:deleteRecord();" value="删除"/>
        <table width="90%" border="1">
            <tr>
                <th><input name="" type="checkbox" class="input_hide" onClick="CheckSelect(this.form);return false;" value=""></th>
            	<th>用户Id</th>
            	<th>用户名称</th>
            	<th>用户密码</th>
            	<th>年龄</th>
            	<th>登录时间</th>
            	<th>操作</th>
            </tr>
	        <s:iterator  value="pageResults.results">
	        	<tr>
	        		<td><input type=checkbox name="ids" value="${id}"></td>
	        		<td><s:property value="id"/></td>
	        		<td><s:property value="username"/></td>
	        		<td><s:property value="password"/></td>
	        		<td><s:property value="age"/></td>
	        		<td><s:date name="lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/></td>
	        		<td><s:a action="user_updateUI" namespace="/user"><s:param name="user.id">${id}</s:param>修改</s:a>
	        		&nbsp;&nbsp;<s:a action="user_delete" namespace="/user"><s:param name="user.id">${id}</s:param>删除</s:a></td>
	        	</tr>
	        </s:iterator>
	        <!-- 分页 -->			
			<jsp:include page="page.jsp">
				<jsp:param value="user_queryAllUser" name="url"/>		
				<jsp:param value="/user" name="urlNameSpace	"/>	
			</jsp:include>
			
		</table>
		</s:form>
    </center>
</body>
</html>