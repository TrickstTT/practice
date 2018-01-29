<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
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
<title>login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #6fafdd;
}

#login {
	margin: 120px auto;
	width: 366px;
	background-color: #eee;
	padding: 30px;
	box-sizing: border-box;
	position: relative;
}

#login h1 {
	text-align: center;
	color: cornflowerblue;
	font-weight: normal;
	border-bottom: 1px solid #ccc;
	margin-bottom: 23px;
	font-size: 28px;
	font-family: "微软雅黑";
}

input {
	display: block;
}

.text {
	width: 306px;
	height: 30px;
	margin-bottom: 20px;
	text-indent: 7px;
}

.bot {
	width: 70px;
	height: 32px;
	border: 5px solid #6495ED;
	background-color: #6495ED;
	cursor: pointer;
	color: #fff;
	display: inline;
	margin-left: 55px;
}

.bot:hover {
	background-color: #48a;
}

.bot:active {
	position: relative;
	left: 2px;
	top: 1px;
}

#vali {
	font-size: 12px;
	height: 40px;
}

#vali img {
	width: 160px;
	height: 40px;
	line-height: 20px;
}

#bottom {
	margin-top: 10px;
	line-height: 15px;
}

font {
	display: none;
}
</style>
</head>
<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if ("userName".equals(c.getName())) {
			request.setAttribute("userName", c.getValue());
		}
		if ("password".equals(c.getName())) {
			request.setAttribute("password", c.getValue());
		}
	}
%>
<body>
	<div id="login">
		<h1>学员后台系统</h1>
		<form id="fom" action="${path }/servlet/Servlet_Login" method="post">
			<input class="text" type="text" name="userName" id="input1"
				value="${userName }" placeholder="身份证号码/学号" /> <input class="text"
				type="password" name="password" id="input2" value="${password }"
				placeholder="密码" />
			<div id="vali">
				<input id="va"
					style="width: 100px; float: left; margin: 5px 30px 10px 0;"
					class="text" type="text" name="vCode" placeholder="请输入验证码" /> <img
					onclick="changeCode(this)" alt="验证码"
					src="${path }/Servlet_ValidateCode"> <br /> 
					<font	color="red">*验证码错误</font>
			</div>
			<div id="bottom">
				<input style="width: 15px; height: 15px; display: inline;"
					type="checkbox" name="checkbox" /> 记住密码 <br /> <br /> 
					<input	type="button" class="bot" id="regist" value="注册" /> 
					<input	type="button" class="bot" id="input3" value="登录" />
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var fom = document.getElementById("fom");
		var p1 = document.getElementById("input1");
		var p2 = document.getElementById("input2");
		var p3 = document.getElementById("input3");
		var regist = document.getElementById("regist");
		var vCode;
		$("#va").focus(function() {
			$("font").css({
				display : "none"
			});
			$.post("${path}/servlet/Servlet_getVcode", {
				name : "hehe"
			}, function(data) {
				vCode = data.toLowerCase();
			});
		});
		regist.onclick = function() {
			window.open("${path }/regist.jsp");
		}
		//改变验证码
		function changeCode(ths) {
			ths.src = "${path }/Servlet_ValidateCode?hehe=" + Math.random();
		}
		//提交
		p3.onclick = function() {
			if (p1.value == "" || p2.value == "") {
				alert("用户名和密码不能为空！！！");
			} else {
				if ($("#va").val().toLowerCase() == vCode ) {
					fom.submit();
				} else {
					$("font").css({
						display : "inline"
					});
				}
			}
		}
	</script>
</body>
</html>