<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Exception Message</title>
</head>
<body>	
	<div>抱歉，服务器内部错误！</div>
	<div>
		输出异常信息本身: <BR><s:property value="exception"/><br>
		输出异常堆栈信息:<br><s:property value="exceptionStack"/><br>
	</div>
	<s:debug></s:debug>

</body>
</html>