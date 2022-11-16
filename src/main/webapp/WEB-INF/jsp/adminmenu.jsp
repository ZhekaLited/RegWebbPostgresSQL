<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
<t:headerAdmin/>
<div class="site-wrap">
    <div class="site-section" id="programs-section">
        <div class="container">
            <div class="row mb-5 justify-content-center">
                <div class="col-lg-7 text-center" data-aos="fade-up" data-aos-delay="">
                    <h2 class="section-title">Welcome</h2>
                    <p>We are proud to show you a few of our recent projects</p>
                </div>
            </div>
            <div class="row mb-5 align-items-center">
                <div class="col-lg-7 mb-5" data-aos="fade-up" data-aos-delay="100">
                    <img src="resources/images/soft.png" alt="Image" class="img-fluid">
                </div>
                <div class="col-lg-4 ml-auto" data-aos="fade-up" data-aos-delay="200">
                    <h2 class="text-black mb-4">DOCTENA - MOBILE APPLICATION</h2>
                    <p class="mb-4">Doctena is an online platform dedicated to help patients search for practitioners
                        (doctors, nurses) and organize appointments with them.</p>

                </div>
            </div>

            <div class="row mb-5 align-items-center">
                <div class="col-lg-7 mb-5 order-1 order-lg-2" data-aos="fade-up" data-aos-delay="100">
                    <img src="resources/images/soft.jpg" alt="Image" class="img-fluid">
                </div>
                <div class="col-lg-4 mr-auto order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
                    <h2 class="text-black mb-4">LottieFiles</h2>
                    <p class="mb-4">LottieFiles is now used by animation and motion designers at 150,000 companies.</p>

                </div>
            </div>

            <div class="row mb-5 align-items-center">
                <div class="col-lg-7 mb-5" data-aos="fade-up" data-aos-delay="100">
                    <img src="resources/images/gamessec.jpg" alt="Image" class="img-fluid">
                </div>
                <div class="col-lg-4 ml-auto" data-aos="fade-up" data-aos-delay="200">
                    <h2 class="text-black mb-4">ButtleTech</h2>
                    <p class="mb-4">A strategy game is a genre of computer games in which the player must
                        use strategic thinking to win.</p>

                </div>
            </div>
        </div>
    </div>
</div>
<t:footer/>
</body>
</html>