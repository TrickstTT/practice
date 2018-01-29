<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

a {
	text-decoration: none;
	color:#000;
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
	margin: 0 auto;
}

#head {
	border-left: 1px solid #ccc;
	/* 	border-right:1px solid #ccc; */
}

.line {
	border-left: 1px solid #ccc;
	height: 230px;
	line-height: 230px;
}

.cell {
	float: left;
	padding: 5px 10px;
	border: 1px solid #ccc;
	text-align: center;
}

#head .cell {
	font-weight: bold;
}

img {
	width: 200px;
	height: 230px;
}

#main {
	height:460px;
}

#page {
	margin: 50px auto;
	padding-left:311px;
	position:relative;
}

a ,#aa{
	width:30px;
	background-color:#69c;
	border:3px solid #69c;
	text-align:center;
	display:inline-block;
}

a:hover {
	background-color: #369;
}

a:active {
	position: relative;
	left: 2px;
	top: 1px;
}
#btn {
	width: 90px;
	height: 30px;
	border: 3px solid #69c;
	background-color: #69c;
	color: #fff;
}

#btn:hover {
	background-color: #369;
}

#btn:active {
	position: relative;
	left: 2px;
	top: 1px;
}
</style>
</head>
<body>
	<div id="cont">
		<!-- 		表头 -->
		<div id="head" class="clearfix">
			<div class="cell" style="width: 200px;">头像</div>
			<div class="cell" style="width: 80px;">姓名</div>
			<div class="cell" style="width: 40px;">性别</div>
			<div class="cell" style="width: 200px;">身份证号码</div>
			<div class="cell" style="width: 170px;">手机号</div>
			<div class="cell" style="width: 140px;">qq</div>
			<div class="cell" style="width: 100px;">学号</div>
			<div class="cell" style="width: 90px;">报名日期</div>
		</div>
		<div id="main">
			<c:forEach items="${page.list }" var="list">
				<div class="line clearfix">
					<div class="cell" style="width: 200px;">
						<img alt="" src="${path }/${list.touXiangImg }">
					</div>
					<div class="cell" style="width: 80px;">${list.name }</div>
					<div class="cell" style="width: 40px;">${list.gender }</div>
					<div class="cell" style="width: 200px;">${list.idCard }</div>
					<div class="cell" style="width: 170px;">${list.phone }</div>
					<div class="cell" style="width: 140px;">${list.qq }</div>
					<div class="cell" style="width: 100px;">${list.number }</div>
					<div class="cell" style="width: 90px;">${list.registerDate }</div>
				</div>
			</c:forEach>
			<%-- 			var="i" begin="${page.startPage }" end="${page.endPage }" step="1"  --%>

		</div>
		<div class="clearfix" id="page" >
			<c:if test="${page.currentPage !=1}">
				<a style="width:70px;" href="${path }/servlet/Servlet_Page?page=${page.currentPage-1}">上一页</a>
			</c:if>
			<c:if test="${page.currentPage ==1}">
				<div id="aa" style="background-color:#ccc;border:3px solid #ccc;width:70px;">上一页</div>
			</c:if>
			<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }" step="1">
				<c:if test="${page.currentPage != i }">
					<a href="${path }/servlet/Servlet_Page?page=${i}">${i }</a>
				</c:if>
				<c:if test="${page.currentPage == i }">
					<div id="aa" style="background-color:#ccc;border:3px solid #ccc;">${i }</div>
				</c:if>
			</c:forEach>
			<c:if test="${page.currentPage != page.totalPage }">
				<a style="width:70px;" href="${path }/servlet/Servlet_Page?page=${page.currentPage+1}">下一页</a>
			</c:if>
			<c:if test="${page.currentPage == page.totalPage }">
				<div id="aa" style="background-color:#ccc;border:3px solid #ccc;width:70px;">下一页</div>
			</c:if>
			<span>共${page.totalPage }页</span>
			<input type="text" id="jump" style="width:50px;height:30px;text-align:center;"/>
			<input type="button" id="btn" value="跳转"/>
		</div>
	</div>
	<script type="text/javascript">
		$("#btn").click(function(){
			if($("#jump").val()>parseInt("${page.totalPage}")){
				window.location="${path }/servlet/Servlet_Page?page=${page.totalPage}";
			}else if($("#jump").val()<1){
				window.location="${path }/servlet/Servlet_Page?page=1";
			}else if(isNaN($("#jump").val())){
				$("#jump").val("");
			}else if($("#jump").val()%1!=0){
				$("#jump").val("");
			}else{

				window.location="${path }/servlet/Servlet_Page?page="+$("#jump").val();
			}
		});
	</script>
</body>
</html>