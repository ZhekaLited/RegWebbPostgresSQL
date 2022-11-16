<%--
  Created by IntelliJ IDEA.
  User: alen
  Date: 16.11.2022
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
    <link rel="stylesheet" href="resources/fonts/icomoon/style.css">

    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/jquery-ui.css">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="resources/css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="resources/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="resources/css/aos.css">

    <link rel="stylesheet" href="resources/css/style.css">

    <link rel="stylesheet" href="resources/plugin/style.css">

</head>
<body>
<header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

    <div class="container-fluid">
        <div class="d-flex align-items-center">
            <div class="site-logo mr-auto w-25"><a href="<c:url value="/adminMenu"/>">LookSoft</a></div>

            <div class=" text-center w-25">
                <nav class="site-navigation position-relative text-right" role="navigation">
                    <ul class="site-menu main-menu js-clone-nav mx-auto d-none d-lg-block m-0 p-0">
                        <li><a href="<c:url value="/adminPanel"/>" class="nav-link" ${hideAdmin}>Users</a></li>
                        <li><a href="<c:url value="/logout"/>" class="nav-link">Logout</a></li>

                    </ul>
                </nav>
            </div>

        </div>
    </div>

</header>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/owl.carousel.min.js"></script>
<script src="resources/js/jquery.stellar.min.js"></script>
<script src="resources/js/jquery.countdown.min.js"></script>
<script src="resources/js/bootstrap-datepicker.min.js"></script>
<script src="resources/js/jquery.easing.1.3.js"></script>
<script src="resources/js/aos.js"></script>
<script src="resources/js/jquery.fancybox.min.js"></script>
<script src="resources/js/jquery.sticky.js"></script>


<script src="resources/js/main.js"></script>

</body>
</html>
