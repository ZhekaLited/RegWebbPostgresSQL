<%--
  Created by IntelliJ IDEA.
  User: alen
  Date: 16.11.2022
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="resources/plugin/bootstrap-drid.min.css">
    <link rel="stylesheet" href="resources/plugin/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="resources/plugin/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400&display=swap"
          rel="stylesheet">
</head>
<body>
<header>
    <nav class="navbar">
        <div class="container">
            <a href="<c:url value="/adminMenu"/>" class="navbar-brand">LookSoft</a>

            <div class="navbar-wrap">
                <ul class="navbar-menu">
                    <li><a href="<c:url value="/adminPanel"/>" class="icon-user" ${hide}>Users</a></li>
                    <li><a href="<c:url value="/logout"/>">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
