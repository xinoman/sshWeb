<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>File Upload Success</title>
</head>
<body>
	<center>
		You have successfully uploaded
		<s:property value="uploadFileName" />
		<br>
		<s:a action="user_queryAllUser" namespace="/user">返回</s:a>
	</center>
</body>
</html>