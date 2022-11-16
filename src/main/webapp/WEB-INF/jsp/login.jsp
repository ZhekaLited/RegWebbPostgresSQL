<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


</head>
<body>
<t:header/>
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
                                    <input type="text" class="form-control" required placeholder="login"
                                           name="login"><br>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" required placeholder="password"
                                           name="password"><br><br>
                                </div>
                                <div><input class="btn btn-primary btn-top btn-pill" type="submit" value="Input"></div>


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
