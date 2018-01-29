
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商城系统</title>
    <jsp:include page="include/head.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">

        <!-- Logo -->
        <a href="/main.do" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>商</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>商品管理系统</b></span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${user.username}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    ${user.name}
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">上传头像</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->

                </ul>
            </div>

        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${user.username}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-shopping-cart"></i>
                        <span>商品管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu" style="display: none;">
                        <li><a href="/goodsCategory.do"><i class="fa fa-circle-o"></i> 商品类别</a></li>
                        <li><a href="/allGoods.do"><i class="fa fa-circle-o"></i> 所有商品</a></li>
                    </ul>
                </li>


                <li class="treeview menu-open active">
                    <a href="#">
                        <i class="fa fa-user "></i>
                        <span>用户管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu active" >
                        <li class="active"><a href="/insertUser.do"><i class="fa fa-circle-o"></i> 新增用户</a></li>
                        <li><a href="/allUser.do"><i class="fa fa-circle-o"></i> 所有用户</a></li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="main.do"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">新增用户</li>
            </ol>
        </section>
        <!-- Content Wrapper. Contains page content -->

        <!-- Main content -->
            <div class="content">
                <div class="box box-primary" style="padding:0 200px;">
                    <div class="box-header with-border">
                        <h3 class="box-title">新增用户</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form id="myForm" role="form" method="post" action="/insertUser.do">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="username">用户名</label>
                                <input name="username" type="text" class="form-control" id="username" placeholder="用户名"/>
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input name="password" type="password" class="form-control" id="password" placeholder="密码"/>
                            </div>
                            <div class="form-group">
                                <label for="phone">手机号</label>
                                <input name="phone" type="password" class="form-control" id="phone" placeholder="手机号"/>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button id="submitBtn" type="button" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                    <!-- form end -->
                </div>
            </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="/login.jsp">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>
    <%-- 弹窗信息 --%>
    <div class="modal fade in" id="myAlert" style="display: none; padding-right: 17px;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">提示信息</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body…</p>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <c:if test="${msg != null}">
        <div onclick="changeToNone(this)" class="modal fade in" id="myAlert" style="display: block; padding-right: 17px;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">提示信息</h4>
                    </div>
                    <div class="modal-body">
                        <p>${msg}</p>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
    </c:if>
</div>
<!-- ./wrapper -->

<jsp:include page="include/foot.jsp"/>

<script type="text/javascript">
    //添加用户成功弹窗 任意点击消失
    function changeToNone(thi){
        thi.style.display = "none";
    }
    $("#submitBtn").bind("click",function (){
        var myAlert = $("#myAlert")
        if($("#username").val().length == 0){
            myAlert.find("p").html("用户名不能为空");
            myAlert.css("display","block");
        }
        else if($("#password").val().length == 0){
            myAlert.find("p").html("密码不能为空");
            myAlert.css("display","block");
        }
        else if($("#phone").val().length == 0){
            myAlert.find("p").html("手机号不能为空");
            myAlert.css("display","block");
        }
        else{
            $("#myForm").submit();
        }
    })
    $("#myAlert").bind("click",function(){
        $("#myAlert").css("display","none");
    })
</script>

</body>
</html>



