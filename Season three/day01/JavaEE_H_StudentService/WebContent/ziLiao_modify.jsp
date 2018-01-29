<%@ page language="java" import="java.util.*,com.kf.bean.User"
	pageEncoding="UTF-8"%>
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

<title>修改资料</title>

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
}

.btn:hover {
	background-color: #369;
}

.btn:active {
	position: relative;
	left: 2px;
	top: 1px;
}

#head {
	text-align: center;
	border-bottom: 1px dotted #ccc;
	padding: 10px 0;
}

#main {
	margin: 10px;
	border: 1px solid #2ab;
	padding: 5px;
	padding-left: 100px;
}

#right {
	border: 1px solid #2ab;
	float: left;
	width:1000px;
}

.line {
	margin: 10px 0;
}

.line .left {
	line-height: 28px;
	font-size: 14px;
	width: 100px;
	border-bottom: 1px solid #fff;
	text-align: right;
	float: left;
}

.line .right {
	height: 28px;
	line-height: 28px;
	font-size: 14px;
	color: #000;
	width: 200px;
	float: left;
	text-indent: 13px;
}
.picture{
	padding:10px 150px;
}
.picture img{
	width:200px;
}
</style>
</head>
<%
	String gender = ((User) request.getSession().getAttribute("user")).getGender();
	String nan = null;
	String nv = null;
	if ("男".equals(gender)) {
		nan = "checked";
	} else if ("女".equals(gender)) {
		nv = "checked";
	}
	request.setAttribute("nan", nan);
	request.setAttribute("nv", nv);
%>
<body>
	<div id="cont">
		<div id="head">
			<h2>编辑个人资料</h2>
			<h3 style="color: red;">以下资料请确保真实有效，请勿删除或随意填写。</h3>
		</div>
		<div id="main" class="clearfix">
			<form id="fm" method="post" action="${path }/servlet/Servlet_Update" enctype="multipart/form-data">
				<input type="hidden" name="userName" value="${user.userName }" />
				<div id="right">
					<div class="line clearfix">
						<div class="left">学员姓名：</div>
						<input type="text" class="right" value="${user.name }" />
					</div>
					<div class="line clearfix">
						<div class="left">性别：</div>
						<input type="radio" name="gender" value="男" ${nan } />男 <input
							type="radio" name="gender" value="女" ${nv } />女
					</div>
					<div class="line clearfix">
						<div class="left">手机号：</div>
						<input type="text" class="right" name="phone" value="${user.phone }" />
					</div>
					<div class="line clearfix">
						<div class="left">QQ：</div>
						<input type="text" class="right" name="qq" value="${user.qq }" />
					</div>
					<div class="line clearfix">
						<div class="left">身份证号码：</div>
						<input type="text" class="right" name="idCard" value="${user.idCard }" />
					</div>
					<div class="line clearfix">
						<div class="left">学校省份：</div>
						<select class="right" name="school1">
							<option value="-1">（未选择）</option>
							<option value="0" >四川</option>
							<option value="1" >重庆</option>
							<option value="2" >广东</option>
							<option value="3" >北京</option>
						</select>
						<div class="left">学校名称：</div>
						<select class="right" name="school2" school="${user.school }">
							<option value="">（未选择）</option>
						</select>
						<div class="left">专业名称：</div>
						<input type="text" name="school3" class="right" />
					</div>
					<div class="line clearfix">
						<div class="left">在校状态：</div>
						<select class="right" id="status" name="status"
							hehe="${user.studyStatus }">
							<option value="">（未选择）</option>
							<option value="在读">在读</option>
							<option value="大一">大一</option>
							<option value="大二">大二</option>
							<option value="大三">大三</option>
							<option value="大四">大四</option>
							<option value="应届">应届</option>
							<option value="非应届">非应届</option>
						</select>
					</div>
					<div class="line clearfix">
						<div class="left">学历：</div>
						<select class="right" name="background" hehe="${user.background }">
							<option value="">（未选择）</option>
							<option value="博士">博士</option>
							<option value="硕士">硕士</option>
							<option value="本科">本科</option>
							<option value="专科">专科</option>
							<option value="高中">高中</option>
						</select>
					</div>
					<!-- 				<div class="line clearfix"> -->
					<!-- 					<div class="left">千锋班级：</div> -->
					<%-- 					<div class="right">${userInfo.className }</div> --%>
					<!-- 				</div> -->
					<!-- 				<div class="line clearfix"> -->
					<!-- 					<div class="left">报名日期：</div> -->
					<%-- 					<div class="right">${userInfo.registerDate }</div> --%>
					<!-- 				</div> -->
					<hr/>
					<div id="picture1" class="picture">
						头像：<br/>
						<img style="height:230px;" alt="" src="${img.touXiangImg }"><br/>
						<input class="" type="file" name="touXiangImg" value="请选择头像"/>
					</div>
					<hr/>
					<div id="picture1" class="picture">
						身份证正面：<br/>
						<img alt="" src="${img.idFontImg }"><br/>
						<input class="" type="file" name="idFontImg" value="请选择头像"/>
					</div>
					<hr/>
					<div id="picture2" class="picture">
						身份证背面：<br/>
						<img alt="" src="${img.idBackImg }"><br/>
						<input class="" type="file" name="idBackImg" value="请选择头像"/>
					</div>
					<hr/>
					<div id="picture3" class="picture">
						毕业证：<br/>
						<img alt="" src="${img.biYeZhengImg }"><br/>
						<input class="" type="file" name="biYeZhengImg" value="请选择头像"/>
					</div>
				</div>
				<div style="line-height:50px;text-indent:400px;">
					<input onclick="submit()" type="button" class="btn" value="提交" />
					<input onclick="back('${path}/ziLiao.jsp')" type="button" class="btn" value="返回" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript">
		//创建省 学校 的二维数组
		var arrShen = new Array(4);
		arrShen[0] = new Array("西南交通大学", "黄湾乡男子铁道技术学院", "四川大学", "成都理工大学");
		arrShen[1] = new Array("重庆大学", "西南大学");
		arrShen[2] = new Array("广州大学", "华南理工大学", "华南农业大学");
		arrShen[3] = new Array("北京交大", "北京邮电", "清华大学");
		// 设置学校默认值
		var school = $("[name = 'school2']").attr("school");
		if (school != null && school != "") {
			var arrSchool = school.split("&");
			var index = parseInt(arrSchool[0]);
			$("[name = 'school3']").val(arrSchool[2]);
			var arr = arrShen[index];
			var s = $("[name='school2']");
			s.html("<option>（未选择）</option>");
			for ( var i in arr) {
				s.append("<option>" + arr[i] + "</option>");
			}
			if(index!=null && index!=""){
				$("[name = 'school1']").val(index);
			}else{
				$("[name = 'school1']").val(-1);
			}
			if(arrSchool[1]!=null && arrSchool[1]!=""){
				$("[name = 'school2']").val(arrSchool[1]);
			}
		}
		//设置在校状态默认值
		function setStatus(hehe) {
			$("#status").val(hehe);
		}
		setStatus($("#status").attr("hehe"));
		//设置学历默认值
		function setBackground(hehe) {
			$("[name='background']").val(hehe);
		}
		setBackground($("[name='background']").attr("hehe"));

		$("[name='school1']").change(function() {
			var arr = arrShen[$(this).val()];
			var s = $("[name='school2']");
			s.html("<option>（未选择）</option>");
			for ( var i in arr) {
				s.append("<option>" + arr[i] + "</option>");
			}
		});
		function back(url){
			window.location = url;
		}
		//提交
		function submit(){
			var size1 = document.getElementById("picture1").files[0].size;
			var size2 = document.getElementById("picture2").files[0].size;
			var size3 = document.getElementById("picture3").files[0].size;
			var size = 1024*1024*5;
			if(size1>size||size2>size||size3>size){
				alert("上传图片大小不得大于1M！！！！")
			}else{
				document.getElementById("fm").submit();
			}
		}
	</script>
</body>
</html>