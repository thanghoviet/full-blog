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
                        <form class="form-header" action="${pageContext.request.contextPath}/post?action=search" method="GET">
                            <input type="hidden" name="action" value="search">
                            <input class="au-input au-input--xl" type="text" name="title" id="title"
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
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- DATA TABLE -->
                            <h3 class="title-5 m-b-35">Post Table</h3>
                            <div class="table-data__tool">
                                <%--                                vị trí nút--%>
                                <div class="table-data__tool-right">
                                </div>
                                    <div class="table-data__tool-left">
                                        <a href="${pageContext.request.contextPath}/post?action=create" class="btn btn-primary btn-sm" style="color: black">
                                            <i class="fas fa-plus"></i> add
                                        </a>
                                    </div>
                                <div class="table-responsive table-responsive-data2" style="overflow-x: scroll">
                                    <table class="table table-data2">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Title</th>
                                            <th>Sort Content</th>
                                            <th>Content</th>
                                            <th>image</th>
                                            <th>Create Date</th>
                                            <th>Edit Date</th>
                                            <th>Poster</th>
                                            <th>Category</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <c:forEach var="post" items="${listPost}">
                                            <tbody>
                                            <tr class="spacer"></tr>
                                            <tr class="tr-shadow">
                                                <td><c:out value="${post.id}"/></td>
                                                <td>
                                                    <a href="/post?action=view&id=${post.id}">
                                                        <c:out value="${post.title}"/></a>
                                                </td>
                                                <td><c:out value="${post.sortContent}"/></td>
                                                <td>
                                                    <img src="${post.image}" alt="img" height="70px" />
                                                </td>
                                                <td><c:out value="${post.createDate}"/></td>
                                                <td><c:out value="${post.editDate}"/></td>
                                                <td><c:out value="${post.use.alias}"/></td>
                                                <td><c:out value="${post.category.title}"/></td>
                                                <td>
                                                    <div class="table-data-feature">
                                                        <button class="item" data-toggle="tooltip" data-placement="top"
                                                                title="Edit">
                                                            <a href="${pageContext.request.contextPath}/post?action=edit&id=${post.id}">
                                                                <i class="zmdi zmdi-edit"></i>
                                                            </a>
                                                        </button>
                                                        <button class="item" data-toggle="tooltip" data-placement="top"
                                                                title="Delete">
                                                            <a href="${pageContext.request.contextPath}/post?action=delete&id=${post.id}"> <i
                                                                    class="zmdi zmdi-delete"></i></a>
                                                            <a href="#" onclick="deletePost(${post.id})"
                                                               class="delete" title="Delete"> <i
                                                                    class="zmdi zmdi-delete"></i></a>
                                                        </button>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="spacer"></tr>
                                            </tbody>
                                        </c:forEach>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a
                                            href="https://colorlib.com">Colorlib</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function deletePost(id) {
                let showMessage = confirm("Do you want to delete this user ?");
                if (showMessage) {
                    alert("Delete successfully!")
                    window.location = "/post?action=delete&id=" + id;
                } else {
                }
            }
        </script>
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
