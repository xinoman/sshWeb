<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<center>
		<h1>用户登录</h1>
		<s:a action="user_addUI" namespace="/user">添加新用户</s:a>
		<s:form action="login" namespace="/" method="post">
			<s:textfield key="user.username" name="user.username" />
			<s:password key="user.password" name="user.password" />
			<s:fielderror/>
			<td><s:submit value="登录" />
			<td><s:reset value="重置" />
		</s:form>
	</center>
	<%-- <tiles:insertDefinition name="index-def" /> --%>
</body>
</html>