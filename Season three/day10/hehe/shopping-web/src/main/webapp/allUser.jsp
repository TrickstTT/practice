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
                    <ul class="treeview-menu active">
                        <li><a href="/insertUser.do"><i class="fa fa-circle-o"></i> 新增用户</a></li>
                        <li class="active"><a href="/allUser.do"><i class="fa fa-circle-o"></i> 所有用户</a></li>
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
                <li class="active">所有用户</li>
            </ol>
        </section>
        <!-- Content Wrapper. Contains page content -->

        <!-- Main content -->
        <div class="content">
            <%-- 表格开始 --%>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Hover Data Table</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                        <div class="row">
                            <div class="col-sm-6"></div>
                            <div class="col-sm-6"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="example2" class="table table-bordered table-hover dataTable" role="grid"
                                       aria-describedby="example2_info">
                                    <thead>
                                        <tr role="row">
                                            <th class="sorting_desc" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1" aria-label="Rendering engine: activate to sort column ascending"
                                                aria-sort="descending">Rendering engine
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1" aria-label="Browser: activate to sort column ascending">
                                                Browser
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                                Platform(s)
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1" aria-label="Engine version: activate to sort column ascending">
                                                Engine version
                                            </th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                                CSS grade
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr role="row" class="odd">
                                        <td class="sorting_1">Webkit</td>
                                        <td class="">iPod Touch / iPhone</td>
                                        <td>iPod</td>
                                        <td>420.1</td>
                                        <td>A</td>
                                    </tr>
                                    <tr role="row" class="even">
                                        <td class="sorting_1">Webkit</td>
                                        <td class="">OmniWeb 5.5</td>
                                        <td>OSX.4+</td>
                                        <td>420</td>
                                        <td>A</td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <%--<tr>--%>
                                        <%--<th rowspan="1" colspan="1">Rendering engine</th>--%>
                                        <%--<th rowspan="1" colspan="1">Browser</th>--%>
                                        <%--<th rowspan="1" colspan="1">Platform(s)</th>--%>
                                        <%--<th rowspan="1" colspan="1">Engine version</th>--%>
                                        <%--<th rowspan="1" colspan="1">CSS grade</th>--%>
                                    <%--</tr>--%>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-5"></div>
                            <%--<div class="col-sm-7">--%>
                                <%--<div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">--%>
                                    <%--<ul class="pagination">--%>
                                        <%--<li class="paginate_button previous disabled" id="example2_previous"><a href="#"--%>
                                                                                                                <%--aria-controls="example2"--%>
                                                                                                                <%--data-dt-idx="0"--%>
                                                                                                                <%--tabindex="0">Previous</a>--%>
                                        <%--</li>--%>
                                        <%--<li class="paginate_button active"><a href="#" aria-controls="example2"--%>
                                                                              <%--data-dt-idx="1" tabindex="0">1</a></li>--%>
                                        <%--<li class="paginate_button "><a href="#" aria-controls="example2"--%>
                                                                        <%--data-dt-idx="2" tabindex="0">2</a></li>--%>
                                        <%--<li class="paginate_button "><a href="#" aria-controls="example2"--%>
                                                                        <%--data-dt-idx="3" tabindex="0">3</a></li>--%>
                                        <%--<li class="paginate_button "><a href="#" aria-controls="example2"--%>
                                                                        <%--data-dt-idx="4" tabindex="0">4</a></li>--%>
                                        <%--<li class="paginate_button "><a href="#" aria-controls="example2"--%>
                                                                        <%--data-dt-idx="5" tabindex="0">5</a></li>--%>
                                        <%--<li class="paginate_button "><a href="#" aria-controls="example2"--%>
                                                                        <%--data-dt-idx="6" tabindex="0">6</a></li>--%>
                                        <%--<li class="paginate_button next" id="example2_next"><a href="#"--%>
                                                                                               <%--aria-controls="example2"--%>
                                                                                               <%--data-dt-idx="7"--%>
                                                                                               <%--tabindex="0">Next</a>--%>
                                        <%--</li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <%-- 表格结束 --%>
        </div>
        <!-- /Main content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="/login.jsp">Almsaeed Studio</a>.</strong> All rights
        reserved.
    </footer>

</div>
<!-- ./wrapper -->

<jsp:include page="include/foot.jsp"/>

</body>
</html>



