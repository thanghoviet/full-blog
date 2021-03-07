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
                <img src="./bootstrap/images/icon/images.png" alt="blog ger" width="179" height="52"/>
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
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- MAIN CONTENT   -->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 col-md-12">
                            <h3 class="title-5 m-b-35">User Manager</h3>
                        </div>
                        <div class="table-data__tool">
                            <div class="table-data__tool-left">

                            </div>
                            <div class="table-data__tool-right"></div>
                        </div>
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
                                <input type="hidden" name="action" value="create" />
                                <div class="card-header">
                                    <strong>Add User</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="email" class=" form-control-label">Email :</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="email" id="email" name="email" placeholder="email"
                                                   required value="${user.email}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="pass1" class=" form-control-label">Password :</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input
                                                    type="password"
                                                    id="pass1"
                                                    name="pass1"
                                                    oninput="handleInputPassword()"
                                                    required
                                                    class="form-control"
                                            />
                                        </div>
                                        <div class="col col-md-3">
                                            <label for="password" class=" form-control-label">Retype Password :</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input
                                                    type="password"
                                                    id="password"
                                                    name="password"
                                                    oninput="handleInputPassword()"
                                                    required
                                                    class="form-control"
                                            />
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="fullName" class=" form-control-label">Full Name :</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="fullName" name="fullName" placeholder="fullName"
                                                   required value="${user.fullName}" class="form-control">
                                        </div>
                                    </div>

                                    <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="alias" class=" form-control-label">Alias :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="alias" name="alias" placeholder="alias"
                                               required value="${user.alias}" class="form-control">
                                    </div>
                                </div>

                                    <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="aboutMe" class=" form-control-label">About Me :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="aboutMe" name="aboutMe" placeholder="about Me"
                                               required value="${user.aboutMe}" class="form-control">
                                    </div>
                                </div>

                                    <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="image" class=" form-control-label">Image :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="text" id="image" name="image" placeholder="image"
                                               required value="${user.image}" class="form-control">
                                    </div>
                                </div>

                                    <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="yearOfBirth" class=" form-control-label">Year Of Birth :</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <input type="number" min="1970" max="2010" id="yearOfBirth" name="yearOfBirth" placeholder="yearOfBirth"
                                               required value="${user.yearOfBirth}" class="form-control">
                                    </div>
                                </div>

                                </div>
                                <div id="check" style="color: red"></div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>
                                    <button type="reset" class="btn btn-danger btn-sm">
                                        <a href="#">
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

<script>
    const pass1 = document.getElementById("pass1");
    const pass2 = document.getElementById("password");
    const check = document.getElementById("check");
    function handleInputPassword() {
        if (pass1.value.trim() === "" || pass1.value !== pass2.value) {
            check.innerText = "2 mật khẩu phải giống nhau ";
        } else {
            check.innerText = "";
        }
    }
</script>

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
