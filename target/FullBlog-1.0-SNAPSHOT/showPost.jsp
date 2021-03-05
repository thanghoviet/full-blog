<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Tables</title>

    <!-- Fontfaces CSS-->
    <link href="./bootstrap/css/font-face.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="./bootstrap/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
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
                        <img src="./bootstrap/images/icon/logo.png" alt="CoolAdmin"/>
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
                <img src="./bootstrap/images/icon/images.png" alt="blog ger" width="179" height="52"/>
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
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
                        <form class="form-header" action="/post?action=search" method="GET">
                            <input type="hidden" name="action" value="search">
                            <input class="au-input au-input--xl" type="text" name="searchTitle" id="searchTitle"
                                   placeholder="Search for Title..."/>
                            <button class="au-btn--submit" type="submit" value="Search">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>
                        <form action="" method="GET">
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
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- MAIN CONTENT-->

        <div class="row">
            <!-- FORM ADD-->
            <div class="col-12 col-md-12">
                <div class="card-header">
                    <strong>Note ${post.id}</strong>
                </div>
                <form>
                    <div class="card-body card-block">
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">Title :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p id="title">${post.title}</p>


                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">Short Content</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p id="sort_content">${post.sortContent}</p>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">Content :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p>${post.content}</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">image :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <img src="${post.image}" height="100px">
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">Create Date :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p>${post.createDate}</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label  class=" form-control-label">Edit Date :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p >${post.editDate}</p>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">User :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p >${post.use.alias}</p>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3">
                                <label class=" form-control-label">Category :</label>
                            </div>
                            <div class="col-12 col-md-9">
                                <p>${post.category.title}</p>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

<!-- Jquery JS-->
<script src="./bootstrap/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="./bootstrap/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="./bootstrap/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS -->
<script src="./bootstrap/vendor/slick/slick.min.js"></script>
<script src="./bootstrap/vendor/wow/wow.min.js"></script>
<script src="./bootstrap/vendor/animsition/animsition.min.js"></script>
<script src="./bootstrap/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="./bootstrap/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="./bootstrap/vendor/counter-up/jquery.counterup.min.js"></script>
<script src="./bootstrap/vendor/circle-progress/circle-progress.min.js"></script>
<script src="./bootstrap/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="./bootstrap/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="./bootstrap/vendor/select2/select2.min.js"></script>

<!-- Main JS-->
<script src="./bootstrap/js/main.js"></script>

</body>

</html>
<!-- end document-->
