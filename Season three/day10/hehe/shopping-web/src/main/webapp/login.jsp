<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商城系统 - 登录</title>
    <jsp:include page="include/head.jsp"/>

</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>商城管理系统</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">欢迎登录商城管理系统</p>

        <!-- 帐号或密码为空提示 -->
        <div id="myAlert" class="alert alert-danger alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            帐号或密码不能为空
        </div>
        <!-- 密码错误提示 -->
        <c:if test="${msg != null}">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    ${msg}
            </div>
        </c:if>

        <!-- form 表单开始 -->
        <form id="myForm" action="login.do" method="post">
            <div class="form-group has-feedback">
                <input id="input1" type="text" class="form-control" placeholder="用户名" name="username">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="input2" type="password" class="form-control" placeholder="密码" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="rememberMe" style="margin-left:50px;"> 记住我
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button id="myBtn" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <!-- form 表单结束 -->

        <a href="#">忘记密码？</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<jsp:include page="include/foot.jsp"/>

<script type="text/javascript">
    $("input").bind("click",function(){
        $("#myAlert").css("display","none");
    })

    $("#myBtn").bind("click",function(){
        var v1 = $("#input1").val();
        var v2 = $("#input2").val();
        if(v1.length == 0 || v2.length == 0){
            $("#myAlert").css("display","block");
        }
        else{
            $("#myForm").submit();
        }
    })
    $("#myAlert").css("display","none");
</script>

</body>
</html>

