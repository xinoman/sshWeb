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
	width: 800px;
}

#header {
	float: left;
	width: 800px;
	height: 150px;
	background: red
}

#daohang {
	float: left;
	width: 150px;
	height: 400px;
	background: blue;
	word-wrap: break-word
}

#right {
	float: right;
	width: 642px;
	height: 400px;
	background: green
}

#mbottom {
	float: left;
	width: 800px;
	height: 150px;
	background: yellow
}
</style>

<div id="container" style="height: auto">

	<div id="header">

		<tiles:insertAttribute name="header" />

	</div>



	<div id="daohang">

		<tiles:insertAttribute name="menu" />

	</div>



	<div id="right" style="border: none">

		<tiles:insertAttribute name="body" />

	</div>



	<div id="mbottom" style="height: 100px">

		<tiles:insertAttribute name="footer" />

	</div>



</div>