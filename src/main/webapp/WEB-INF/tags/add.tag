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
            <a href="<c:url value="/adminMenu"/>" class="navbar-brandd">LookSoft</a>

            <div class="navbar-wrap">
                <ul class="navbar-menu">
                    <li><a href="<%=request.getContextPath()%>/adminPanel" class="icon-user" ${hide}>Users</a></li>
                </ul>
                <div class="navbar-wrap navbar-menu">
                    <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>

                <ul>
                </ul>
            </div>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
