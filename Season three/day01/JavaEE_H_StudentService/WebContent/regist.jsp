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

<title>学员注册</title>

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

.btn {
	width: 90px;
	height: 30px;
	border: 3px solid #69c;
	background-color: #69c;
	color: #fff;
	margin-left: 70px;
}

.btn:hover {
	background-color: #369;
}

.btn:active {
	position: relative;
	left: 2px;
	top: 1px;
}

#bottom {
	padding-top: 40px;
	padding-left: 209px;
}

#head {
	text-align: center;
	background-color: #2ab;
	line-height: 90px;
}

#main {
	background-color: #ddd;
	width: 1000px;
	height: 700px;
	margin: 0 auto;
	box-sizing: border-box;
	padding: 40px 70px;
}

.line {
	margin: 20px 0;
}

.line .left {
	line-height: 40px;
	font-size: 18px;
	width: 200px;
	text-align: right;
	float: left;
}

.line .right {
	height: 33px;
	line-height: 33px;
	font-size: 18px;
	color: #000;
	width: 300px;
	float: left;
	text-indent: 13px;
}

.gender {
	float: left;
	padding: 0 10px;
	cursor: pointer;
	margin: 0 5px;
}
</style>
</head>

<body>
	<div id="cont">
		<div id="head">
			<h1>欢迎注册本网站</h1>
		</div>
		<div id="main">
			<form id="fm" action="${path }/servlet/Servlet_Regist" method="post">
				<div class="line clearfix">
					<div class="left">用户名：</div>
					<input name="userName" type="text" class="right" value=""
						placeholder="（必填）" />
					<div id="userName"
						style="padding-left: 30px; line-height: 33px; float: left;color:red;"></div>
				</div>
				<div class="line clearfix">
					<div class="left">密码：</div>
					<input name="password" type="password" class="right" value=""
						placeholder="（必填）" />
					<div id="password"
						style="padding-left: 30px; line-height: 33px; float: left;color:red;"></div>
				</div>
				<div class="line clearfix">
					<div class="left">确认密码：</div>
					<input name="password2" type="password" class="right" value=""
						placeholder="（必填）" />
					<div id="password2"
						style="padding-left: 30px; line-height: 33px; float: left;color:red;"></div>
				</div>
				<div class="line clearfix">
					<div class="left">姓名：</div>
					<input name="name" type="text" class="right" value="" placeholder="（必填）" />
					<div id="name"
						style="padding-left: 30px; line-height: 33px; float: left;color:red;"></div>
				</div>
				<div class="line clearfix"
					style="font-size: 18px; line-height: 40px;">
					<div class="left" class="clearfix">性别：</div>
					<label id="nan" class="gender"> <input type="radio"
						name="gender" value="男" checked />男
					</label> <label id="nv" class="gender"> <input type="radio"
						name="gender" value="女" />女
					</label>
				</div>
				<div class="line clearfix">
					<div class="left">选择地区：</div>
					<select style="width: 170px;" class="right" id="city" name="city">
						<option value="">（未选择）</option>
						<option value="0&北京&BJ">北京</option>
						<option value="1&上海&SH">上海</option>
						<option value="2&重庆&CQ">重庆</option>
						<option value="3&广州&GZ">广州</option>
						<option value="4&深圳&SZ">深圳</option>
					</select>
					<!-- 					<div id="city" style="position:relative;left:-392px;line-height:33px;color:red;float:right;font-size:14px;">*请填写此字段</div> -->
					<div class="left" style="padding-left: -20px;">选择课程：</div>
					<select style="width: 170px;" class="right" id="subject"
						name="subject">
						<option value="">（未选择）</option>
					</select>
				</div>
				<div class="line clearfix">
					<div class="left">手机号：</div>
					<input type="text" class="right" name="phone" value=""
						placeholder="（选填）" />
				</div>
				<div class="line clearfix">
					<div class="left">QQ：</div>
					<input type="text" class="right" name="qq" value=""
						placeholder="（选填）" />
				</div>
				<div class="line clearfix">
					<div class="left">身份证号码：</div>
					<input type="text" class="right" name="idCard" value=""
						placeholder="（选填）" />
				</div>
				<div id="bottom">
					<input class="btn" type="button" value="提交" name=""
						onclick="submitt()" /> <input class="btn" type="button"
						value="关闭" name="" onclick="closeW()" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript">
		var flagUserName = false;
		var flagUserNameQ = false;
		var flagPassword = false;
		var flagPasswordQ = false;
		var flagPassword2 = false;
		var flagPassword2Q = false;
		var flagName = false;
		//创建城市科目二级数组
		var arrCity = new Array(5);
		arrCity[0] = new Array("Html","Java","PHP","Android","UI","IOS","Python");
		arrCity[1] = new Array("Html","PHP","Android","UI","IOS","Python");
		arrCity[2] = new Array("Html","Java","Python");
		arrCity[3] = new Array("Html","Java");
		arrCity[4] = new Array("Html","Java","PHP","Android","UI");
		//城市select改变事件
		$("#city").change(function(){
			var str = $(this).val().split("&");
			var index = parseInt(str[0]);
			var arr = arrCity[index];
			var s = $("#subject");
			s.html("<option>（未选择）</option>")
			for(var i in arr){
				s.append("<option>"+arr[i]+"</option>");
			}
		});
		function closeW() {
			window.close();
		}
		//提交
		function submitt() {
			if($("[name='userName']").val()==null || $("[name='userName']").val()==""){
				$("#userName").html("*请填写此字段");
				flagUserName = false;
			}else{
				flagUserName = true;
			}
			if($("[name='password']").val()==null || $("[name='password']").val()==""){
				$("#password").html("*请填写此字段");
				flagPassword = false;
			}else{
				flagPassword = true;
			}
			if($("[name='password2']").val()==null || $("[name='password2']").val()==""){
				$("#password2").html("*请填写此字段");
				flagPassword2 = false;
			}else{
				flagPassword2 = true;
			}
			if($("[name='name']").val()==null || $("[name='name']").val()==""){
				$("#name").html("*请填写此字段");
				flagName = false;
			}else{
				$("#name").html("");
				flagName = true;
			}
			if(flagUserName && flagUserNameQ && flagPassword && flagPassword2 && flagPasswordQ && flagPassword2Q && flagName ){
				$("#fm").submit();
			}
			
		}
		//判断用户名
		$("[name='userName']").keyup(function(){
			$.post("/JavaEE_H_StudentService/servlet/Servlet_isHave",
					{userName:$("[name='userName']").val()},
					function(data){
						$("#userName").html("<font color='red'>"+data+"</font>");
						if(data=="*可以使用"){
							flagUserNameQ = true;
						}else{
							flagUserNameQ = false;
						}
					});
		});
		//判断密码不小于6位
		$("[name='password']").keyup(function(){
			if(/[0-9a-zA-Z]{6,19}/.test($(this).val())){
				$("#password").html("");
				flagPasswordQ = true;
			}else{
				$("#password").html("<font color='red'>*密码长度不小于6位</font>");
				flagPasswordQ = false;
			}
		});
		$("[name='password2']").change(function(){
			if(($(this).val() == $("[name='password']").val())){
				$("#password2").html("");
				flagPassword2Q = true;
			}else{
				$("#password2").html("<font color='red'>*两次密码不相同</font>");
				flagPassword2Q = false;
			}
		});
		$("[name='password']").change(function(){
			if(($(this).val() == $("[name='password2']").val())){
				$("#password2").html("");
				flagPassword2Q = true;
			}else{
				$("#password2").html("<font color='red'>*两次密码不相同</font>");
				flagPassword2Q = false;
			}
		});
		//用姓名提示清空
		$("[name = 'name']").change(function(){
			$("#name").html("");
		});
	</script>
</body>
</html>