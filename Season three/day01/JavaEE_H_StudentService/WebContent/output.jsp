<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>success</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

a {
	font-style: normal;
}

.clearfix::after {
	content: "";
	display: block;
	height: 0;
	overflow: hidden;
	visibility: hidden;
	clear: both;
	zoom: 1;
}
input{
	height:30px;
	width:300px;
	font-size:18px;
}
.btn {
	width: 90px;
	height: 30px;
	border: 3px solid #69c;
	background-color: #69c;
	color: #fff;
}

.btn:hover {
	background-color: #369;
}

.btn:active {
	position: relative;
	left: 2px;
	top: 1px;
}
#head{
	height:300px;
	width:1100px;
	margin:50px auto;
	background-color:#eee;
	line-height:60px;
	text-align:center;
	font-size:18px;
	color:#555;
	padding-top:100px;
}
</style>
</head>

<body>
	<div id="cont">
		<div id="head">
			<form action="${path }/serlvet/Servlet_Output">
				表格名称：<input name="namehehe"  type = "text"   /><br/>
				存储路径：<input name="url "type = "text"   /><br/>
				<input class="btn"  type = "button" value="导出" onclick="output()" /><br/>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function output(){
			window.location = "${path}/servlet/Servlet_Output";
		}
	</script>
</body>
</html>