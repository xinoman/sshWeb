<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>tiles menu</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<center>
		<s:a action="user_queryAllUser" namespace="/user">用户列表</s:a><br>
		<s:a action="file_fileUploadUI" namespace="/file">文件上传</s:a>
	</center>
</body>
</html>