<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


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


</head>
<body>


<div class="site-wrap">
    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 "></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>
</div>


    <header class="site-navbar py-4 js-sticky-header site-navbar-target menu" role="banner">

        <div class="container-fluid">
            <div class=" align-items-center">
                <div class="site-logo mr-auto w-25"><a href="<c:url value="/logout"/>">LookSoft</a></div>


            </div>
        </div>

    </header>

    <div class="intro-section" id="home-section">

        <div class="slide-1" style="background-image: url('resources/images/Personpg.jpg');">
            <div class="container">
                <div class="row align-items-center ">
                    <div class="col-12">
                        <div class="row align-items-center">


                            <div class="col-lg-5 ml-sign text-center" data-aos="fade-up" data-aos-delay="500">
                                <form method="POST" class="form-box">
                                    <h3 class="h4 text-black mb-4">Sign Up</h3>
                                    <div class="form-group">
                                        <input type="text" class="form-control" required placeholder="login" name="login"><br>
                                    </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" required placeholder="password" name="password"><br><br>
                                        </div>
                                      <div><input class="btn btn-primary btn-pill" type="submit" value="Войти"></div>



                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



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
