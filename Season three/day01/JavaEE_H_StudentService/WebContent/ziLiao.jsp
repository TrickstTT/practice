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

<title>???</title>

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

#cont {
	padding: 15px;
}

#head {
	height: 35px;
	text-align: right;
	padding-right: 40px;
	border-bottom: 1px dashed #ccc;
}
/* 按钮样式 */
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
#main{
	margin:15px;
}
#left{
	margin:0 40px;
	float:left;
}
#img{
	padding:5px;
	border:1px solid #ccc;
	width:202px;
	margin:0 auto;
}
#img img{
	width:200px;
	height:230px;
	border:1px dotted #ccc;
}
#name{
	margin-top:10px;
	background-color:#2ab;
	width:250px;
	line-height:30px;
	text-align:center;
	color:#fff;
}
#right{
	border:1px solid #2ab;
	float:left;
}
.line .left{
	line-height:35px;
	font-size:14px;
	width:100px;
	border-bottom:1px solid #fff;
	padding-right:10px;
	text-align:right;
	background-color:rgba(200,220,240,0.5);
	color:#25a;
	float:left;
}
.line .right{
	height:35px;
	margin-left:10px;
	line-height:35px;
	font-size:14px;
	color:#000;
	border-bottom:1px dotted #ccc;
	width:700px;
	float:left;
	text-indent:13px;
}
</style>

</head>
<body>
	<div id="cont">
		<div id="head">
			<input class="btn" type="button" value="修改" onclick="modify('${path}/ziLiao_modify.jsp')" />
		</div>
		<div id="main" class="clearfix">
			<div id="left">
				<div id="img">
					<img alt="头像" src="${img.touXiangImg }">
				</div>
				<div id="name">${user.name } &nbsp&nbsp (${user.gender })</div>
			</div>
			<div id="right">
				<div class="line clearfix">
					<div class="left">身份证号码</div>
					<div class="right">${userInfo.idCard } </div>
				</div>
				<div class="line clearfix">
					<div class="left">手机号</div>
					<div class="right">${userInfo.phone } </div>
				</div>
				<div class="line clearfix">
					<div class="left">QQ</div>
					<div class="right">${userInfo.qq } </div>
				</div>
				<div class="line clearfix">
					<div class="left">学号</div>
					<div class="right">${userInfo.number }</div>
				</div>
				<div class="line clearfix">
					<div class="left">毕业学校</div>
					<div class="right">${userInfo.school }</div>
				</div>
				<div class="line clearfix">
					<div class="left">在校状态</div>
					<div class="right">${userInfo.studyStatus }</div>
				</div>
				<div class="line clearfix">
					<div class="left">学历</div>
					<div class="right">${userInfo.background }</div>
				</div>
				<div class="line clearfix">
					<div class="left">千锋班级</div>
					<div class="right">${userInfo.className }</div>
				</div>
				<div class="line clearfix">
					<div class="left">报名日期</div>
					<div class="right">${userInfo.registerDate }</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function modify(path){
		window.location=path;
	}
</script>
</html>