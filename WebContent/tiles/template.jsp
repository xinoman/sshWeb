<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">

<style>
#container {
	margin-left: auto;
	margin-right: auto;
	width: 1024px;
}

#header {
	float: left;
	width: 1024px;
	height: 150px;
	background: #63B8FF
}

#menu {
	float: left;
	width: 154px;
	height: 680px;
	background:#B9D3EE;
	word-wrap: break-word
}

#body {
	float: right;
	width: 870px;
	height: 680px;
	background: #B2DFEE
}

#footer {
	float: left;
	width: 1024px;
	height: 40px;
	background:#7EC0EE
}
</style>

<div id="container" style="height:auto">
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="menu">
		<tiles:insertAttribute name="menu" />
	</div>

	<div id="body" style="border:none">
		<tiles:insertAttribute name="body" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>