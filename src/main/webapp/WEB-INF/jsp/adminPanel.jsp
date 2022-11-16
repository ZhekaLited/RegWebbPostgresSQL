<%--
  Created by IntelliJ IDEA.
  User: alen
  Date: 06.11.2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>
    <link rel="stylesheet" href="resources/plugin/bootstrap-drid.min.css">
    <link rel="stylesheet" href="resources/plugin/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="resources/plugin/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,400;0,700;1,400&display=swap"
          rel="stylesheet">
    <title>Admin-Panel</title>
</head>
<t:headerPanel/>
<body>
<div><h2 class="site-title">Users</h2>
    <img src="resources/images/628183.png" class="plus cross" onclick="location.href='/RegWebb_war_exploded/addPanel'">

</div>
<ul class="crop">
</ul>
<div class="table">
    <table>
        <thead>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>email</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Patronymic</th>
            <th>Birthday</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${User}">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.patronymic}</td>
                <td><fmt:formatDate pattern="dd.MM.yyyy" value="${user.birthday}"/></td>
                <td>${user.role}</td>
                <td><img src="resources/images/3673174.png" class="edit cross"
                         onclick="location.href='/RegWebb_war_exploded/editPanel?id=${user.password}'">
                    <img src="resources/images/521708.png" class="edit cross"
                         onclick="location.href='/RegWebb_war_exploded/removePanel?id=${user.password}'"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="list_user">
    <h1>List of Users</h1>
    <ol>
        <c:forEach var="userr" varStatus="userLop" items="${User}">
            <li>
                <c:if test="${userLop.index < 3}">
                    <p>${userr.login}</p>
                    <p>${userr.password}</p>
                    <p>${userr.email}</p>
                    <p>${userr.surname}</p>
                    <p>${userr.name}</p>
                    <p>${userr.patronymic}</p>
                    <p><fmt:formatDate pattern="dd.MM.yyyy" value="${userr.birthday}"/></p>
                    <p>${userr.role}</p>
                </c:if>
                <c:if test="${userLop.index >= 2}">
                    <c:choose>
                        <c:when test="${userLop.index == 3}">
                            <p>${userr.name}</p>
                            <p>${userr.login}</p>
                            <p>${userr.password}</p>
                            <c:out value="Половина"/>
                        </c:when>
                        <c:when test="${userLop.index == 4}">
                            <p>${userr.name}</p>
                            <p>${userr.login}</p>
                            <p>${userr.password}</p>
                        </c:when>
                        <c:otherwise>
                            <p>${userr.name}</p>
                            <p>${userr.login}</p>
                            <p>${userr.password}</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </li>
        </c:forEach>
    </ol>
</div>
<t:footer/>
</body>

</html>
