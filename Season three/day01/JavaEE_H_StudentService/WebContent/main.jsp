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

<title>学员后台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.11.0.js"> </script>
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
	width:1423px;
}

#head {
	height: 50px;
	background-color: #5599bb;
}

#head h1 {
	color: #fff;
	line-height: 45px;
	font-weight: normal;
	font-size: 27px;
	font-family: "楷体";
	margin-left: 60px;
}

#main {
	width:1423px;
}

#left {
	background-color: darkgrey;
	float: left;
}

#left button {
	width: 190px;
	height: 40px;
	background-color: #2ab;
	cursor: pointer;
}

.list {
	background: #fff;
}

.list p {
	height: 40px;
	line-height: 40px;
	color: #3377aa;
	text-align: center;
	font-size: 14px;
	border-bottom: 1px solid #ccc;
	background-color: #eee;
	cursor: pointer;
}

.list ul {
	display: none;
}

.list li {
	height: 40px;
	line-height: 40px;
	padding-left: 55px;
	color: #777;
	font-size: 14px;
	border-bottom: 1px solid #ccc;
	background-color: #eff;
	cursor: pointer;
}

.list p:hover, .list li:hover {
	background-color: #fff;
	color: #3377aa;
}

#right {
	border-left: 1px solid #ccc;
	min-height: 670px; 
	float: left;
	width: 1232px;
	border-botton:1px solid #ccc;
}

#r_head {
	height: 40px;
	background-color: #ddd;
	line-height:40px;
	text-indent:10px;
	color:#089;
	font-size:14px;
}

#r_main {
	padding: 5px;
}

iframe {
	overflow: visible;
	border: none;
}
</style>
</head>
<body>
	<div id="cont">
		<div id="head">
			<h1>学员系统</h1>
		</div>
		<div id="main" class="clearfix">
			<div id="left">
				<button></button>
				<div class="list" id="houTai">
					<p class="listt">学员后台</p>
					<ul style="display: block;">
						<li onclick="change(this,'${path}/touSu.jsp')">匿名投诉</li>
						<li onclick="change(this,'${path}/touSu.jsp')">技术问题</li>
						<li id="init" onclick="change(this,'${path}/ziLiao.jsp')">我的资料</li>
						<li onclick="change(this,'${path}/touSu.jsp')">交费明细</li>
						<li onclick="change(this,'${path}/touSu.jsp')">参加考试</li>
						<li onclick="change(this,'${path}/touSu.jsp')">学员评价</li>
						<li onclick="change(this,'${path}/touSu.jsp')">学员周报</li>
						<li onclick="change(this,'${path}/touSu.jsp')">VIP</li>
						<li onclick="change(this,'${path}/touSu.jsp')">项目上传</li>
					</ul>
				</div>
				<div class="list" id="tiaoZhan">
					<p class="listt">编程挑战</p>
					<ul>
						<li onclick="change(this,'${path}/touSu.jsp')">编程题库</li>
						<li onclick="change(this,'${path}/touSu.jsp')">答题状态</li>
						<li onclick="change(this,'${path}/touSu.jsp')">班级答题情况</li>
					</ul>
				</div>
				<div class="list" id="kaoQin">
					<p class="listt">学员考勤</p>
					<ul>
						<li onclick="change(this,'${path}/touSu.jsp')">学员请假</li>
						<li onclick="change(this,'${path}/touSu.jsp')">学员违纪</li>
					</ul>
				</div>
				<div class="list" id="xiTong">
					<p class="listt">学员信息系统</p>
					<ul>
						<li onclick="change(this,'${path}/servlet/Servlet_Page?page=1')">所有学生信息</li>
						<li onclick="change(this,'${path}/output.jsp')">信息导出</li>
					</ul>
				</div>
			</div>
			<div id="right">
				<div id="r_head"></div>
				<iframe src="#" width="100%" height="680px"></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript">
		var arrLi = document.getElementsByTagName("li");
		var houTai = document.getElementById("houTai");
		var tiaoZhan = document.getElementById("tiaoZhan");
		var kaoQin = document.getElementById("kaoQin");
		var xiTong = document.getElementById("xiTong");
		var arrList = document.getElementsByClassName("listt");
		var r_head = document.getElementById("r_head");
		var flag0 = "open";
		var flag1 = "close";
		var flag2 = "close";
		var flag3 = "close";
		var ifr = document.getElementsByTagName("iframe")[0];
		//点击li改变li的颜色和iframe的src
		function change(ths, url) {
			for (var i = 0; i < arrLi.length; i++) {
				var li = arrLi[i];
				li.style.backgroundColor = "#eff";
				li.style.color = "#777";
			}
			r_head.innerHTML = ths.parentNode.previousElementSibling.innerText+" > "+ths.innerText;
			ths.style.backgroundColor = "#2ab";
			ths.style.color = "#fff";
			ifr.src = url;
		}
		//li添加样式
		var arrLi = document.getElementsByTagName("li");
		
		//默认选中我的资料界面
		$("#init").click();
		
		//学员后台的点击事件
		arrList[0].onclick = function() {
			var ul = arrList[0].nextElementSibling;
			if (flag0 == "close") {
				for (var k = 0; k < arrList.length; k++) {
					arrList[k].nextElementSibling.style.display = "none";
				}
				ul.style.display = "block";
				flag0 = "open";
				flag1 = "close";
				flag2 = "close";
				flag3 = "close";
			} else {
				ul.style.display = "none";
				flag0 = "close";
			}
		}
		//编程挑战的点击事件
		arrList[1].onclick = function() {
			var ul = arrList[1].nextElementSibling;
			if (flag1 == "close") {
				for (var k = 1; k < arrList.length; k++) {
					arrList[k].nextElementSibling.style.display = "none";
				}
				ul.style.display = "block";
				flag1 = "open";
				flag2 = "close";
				flag3 = "close";
			} else {
				ul.style.display = "none";
				flag1 = "close";
			}
		}
		//学员考情的点击事件
		arrList[2].onclick = function() {
			var ul = arrList[2].nextElementSibling;
			if (flag2 == "close") {
				for (var k = 1; k < arrList.length; k++) {
					arrList[k].nextElementSibling.style.display = "none";
				}
				ul.style.display = "block";
				flag2 = "open";
				flag1 = "close";
				flag3 = "close";
			} else {
				ul.style.display = "none";
				flag2 = "close";
			}
		}
		//学员信息系统的点击事件
		arrList[3].onclick = function() {
			var ul = arrList[3].nextElementSibling;
			if (flag3 == "close") {
				for (var k = 1; k < arrList.length; k++) {
					arrList[k].nextElementSibling.style.display = "none";
				}
				ul.style.display = "block";
				flag3 = "open";
				flag2 = "close";
				flag1 = "close";
			} else {
				ul.style.display = "none";
				flag3 = "close";
			}
		}
	</script>
</body>
</html>
