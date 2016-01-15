<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
     });
</script>
</head>
<body id="body">
	<center>
		<h1>文件上传</h1>
		<!--在进行文件上传时，表单提交方式一定要是post的方式，因为文件上传时二进制文件可能会很大，还有就是enctype属性，这个属性一定要写成multipart/form-data，
　　不然就会以二进制文本上传到服务器端-->
		<s:form action="file_execute" namespace="/file" method="post" enctype="multipart/form-data">
			<s:file name="upload" label="上传文件"></s:file><br>
			<s:file name="upload" label="上传文件"></s:file><br>
			<s:file name="upload" label="上传文件"></s:file><br>
			<s:submit value="上传" />			
			<s:fielderror/>
		</s:form>
	</center>
</body>
</html>
