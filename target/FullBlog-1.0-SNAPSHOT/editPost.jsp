<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Forms</title>

    <!-- Fontfaces CSS-->
    <link href="./bootstrap/css/font-face.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="./bootstrap/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="./bootstrap/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet"
          media="all">
    <link href="./bootstrap/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="./bootstrap/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="${pageContext.request.contextPath}/home?action=home">
                        <img src="./bootstrap/images/icon/images.png" alt="CoolAdmin"/>
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                    </button>
                </div>
            </div>
        </div>
        <nav class="navbar-mobile">
            <div class="container-fluid">
                <ul class="navbar-mobile__list list-unstyled">
                    <c:if test="${sessionScope.account.role}">
                        <li>
                            <a href="user?action=listUser">
                                <i class="fas fa-chart-bar"></i> User Management</a>
                        </li>
                    </c:if>
                    <li>
                        <a href="post?action=list">
                            <i class="fas fa-table"></i> Post Management</a>
                    </li>
                    <li>
                        <a href="category?action=list">
                            <i class="far fa-check-square"></i> Category Management</a>
                    </li>
                    <li>
                        <a href="comment?action=list">
                            <i class="fas fa-calendar-alt"></i> Comment Management</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/home?action=home">
                <img src="./bootstrap/images/icon/logo.png" alt="Cool Admin"/>
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="navbar-mobile__list list-unstyled">
                    <c:if test="${sessionScope.account.id == 1}">
                        <li>
                            <a href="user?action=listUser">
                                <i class="fas fa-chart-bar"></i> User Management</a>
                        </li>
                    </c:if>
                    <li>
                        <a href="post?action=list">
                            <i class="fas fa-table"></i> Post Management</a>
                    </li>
                    <li>
                        <a href="category?action=list">
                            <i class="far fa-check-square"></i> Category Management</a>
                    </li>
                    <li>
                        <a href="comment?action=list">
                            <i class="fas fa-calendar-alt"></i> Comment Management</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">

                        <div class="header-button">
                            <div class="noti-wrap">
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-comment-more"></i>
                                    <span class="quantity">1</span>
                                    <div class="mess-dropdown js-dropdown">
                                        <div class="mess__title">
                                            <p>You have 2 news message</p>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="./bootstrap/images/icon/avatar-06.jpg" alt="Michelle Moreno"/>
                                            </div>
                                            <div class="content">
                                                <h6>Michelle Moreno</h6>
                                                <p>Have sent a photo</p>
                                                <span class="time">3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="./bootstrap/images/icon/avatar-04.jpg" alt="Diane Myers"/>
                                            </div>
                                            <div class="content">
                                                <h6>Diane Myers</h6>
                                                <p>You are now connected on message</p>
                                                <span class="time">Yesterday</span>
                                            </div>
                                        </div>
                                        <div class="mess__footer">
                                            <a href="#">View all messages</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-email"></i>
                                    <span class="quantity">1</span>
                                    <div class="email-dropdown js-dropdown">
                                        <div class="email__title">
                                            <p>You have 3 New Emails</p>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="./bootstrap/images/icon/avatar-06.jpg" alt="Cynthia Harvey"/>
                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, 3 min ago</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="./bootstrap/images/icon/avatar-05.jpg" alt="Cynthia Harvey"/>
                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, Yesterday</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="./bootstrap/images/icon/avatar-04.jpg" alt="Cynthia Harvey"/>
                                            </div>
                                            <div class="content">
                                                <p>Meeting about new dashboard...</p>
                                                <span>Cynthia Harvey, April 12,,2018</span>
                                            </div>
                                        </div>
                                        <div class="email__footer">
                                            <a href="#">See all emails</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-notifications"></i>
                                    <span class="quantity">3</span>
                                    <div class="notifi-dropdown js-dropdown">
                                        <div class="notifi__title">
                                            <p>You have 3 Notifications</p>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c1 img-cir img-40">
                                                <i class="zmdi zmdi-email-open"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a email notification</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c2 img-cir img-40">
                                                <i class="zmdi zmdi-account-box"></i>
                                            </div>
                                            <div class="content">
                                                <p>Your account has been blocked</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-file-text"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a new file</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__footer">
                                            <a href="#">All notifications</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="${sessionScope.account.image}" alt="John Doe"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">${sessionScope.account.email}</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="${sessionScope.account.image}" alt="John Doe"/>
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">${sessionScope.account.alias}</a>
                                                </h5>
                                                <span class="email">${sessionScope.account.email}</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Account</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="/logout">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT   -->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid"> r
                </div>
                <div class="row">
                    <c:if test="${message!=null}">
                        <div class="col-12 col-md-12">
                            <div class="alert alert-primary"><i>${message}</i></div>
                        </div>
                    </c:if>
                </div>
                <div class="row">
                    <!-- FORM ADD-->
                    <div class="col-12 col-md-12">
                        <form method="post" class="form-horizontal">
                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" name="id" value="${post.id}">
                            <div class="card-header">
                                <strong>Edit Post</strong>
                            </div>
                            <div class="card-body card-block">
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="title" class=" form-control-label">title :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="title" name="title" placeholder="name"
                                               required value="${post.title}" class="form-control">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="sort_content" class=" form-control-label">sort content :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="sort_content" name="sort_content"
                                               placeholder="Content" value="${post.sortContent}"
                                               class="form-control">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="content" class=" form-control-label">content :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="content" name="content"
                                               placeholder="Content" value="${post.content}"
                                               class="form-control">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="image" class=" form-control-label">image :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="image" name="image"
                                               placeholder="Content" value="${post.image}"
                                               class="form-control">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="category" class=" form-control-label">Category</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <select name="category" id="category" class="category-control">
                                            <c:forEach items="${listCategory}" var="category">
                                                <option value="${category.id}">${category.title}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Submit
                                </button>
                                <button type="reset" class="btn btn-danger btn-sm">
                                    <a href="note">
                                        <i class="fa fa-ban"></i> Reset
                                    </a>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>
                                Copyright © 2018 Colorlib. All rights reserved. Template by <a
                                    href="https://colorlib.com">Colorlib</a>.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MAIN CONTENT-->
    <!-- END PAGE CONTAINER-->
</div>

</div>

<!-- Jquery JS-->
<script src="./bootstrap/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="./bootstrap/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="./bootstrap/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS -->
<script src="./bootstrap/vendor/slick/slick.min.js">
</script>
<script src="./bootstrap/vendor/wow/wow.min.js"></script>
<script src="./bootstrap/vendor/animsition/animsition.min.js"></script>
<script src="./bootstrap/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="./bootstrap/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="./bootstrap/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="./bootstrap/vendor/circle-progress/circle-progress.min.js"></script>
<script src="./bootstrap/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="./bootstrap/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="./bootstrap/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="./bootstrap/js/main.js"></script>

</body>

</html>
<!-- end document-->
