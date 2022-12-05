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
    <t:headerPanel/>
    <link type="images/png" href="resources/images/edit.png" rel="icon">
    <title>Admin-Panel</title>
</head>
<body>
<div><h2 class="site-title">Users</h2>
    <img src="resources/images/628183.png" class="plus cross" onclick="location.href='<c:url value="/addPanel"/>'">

    <%--    ?rer=f--%>


</div>
<ul class="crop">
</ul>
<div class="table">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Password</th>
            <th>Age</th>
            <th>Salary</th>
            <th>name</th>
            <th>Role</th>
            <th>Birthday</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td><c:out value="${user.salary}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td>
                    <c:forEach var ="role" items="${user.role}">
                    <c:out value="${role}"/>
                </c:forEach>
                </td>
                <td><fmt:parseDate var="parsedBirthday" pattern="yyyy-MM-dd"
                                   value="${user.birthday}"/>
                    <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedBirthday}"/></td>
                <td><img src="resources/images/3673174.png" class="edit cross"
                         onclick=location.href='<c:url value="/editPanel?id=${user.login}"/>'>
                    <img src="resources/images/521708.png" class="edit cross"
                         onclick=location.href='<c:url value="/removePanel?login=${user.login}"/>'>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--<div class="list_user">--%>
<%--    <h1>List of Users</h1>--%>
<%--    <ol>--%>
<%--        <c:forEach var="userr" varStatus="userLop" items="${User}">--%>
<%--            <li>--%>
<%--                <c:if test="${userLop.index < 3}">--%>
<%--                    <p>${userr.login}</p>--%>
<%--                    <p>${userr.password}</p>--%>
<%--                    <p>${userr.email}</p>--%>
<%--                    <p>${userr.surname}</p>--%>
<%--                    <p>${userr.name}</p>--%>
<%--                    <p>${userr.patronymic}</p>--%>
<%--                    <p><fmt:formatDate pattern="dd.MM.yyyy" value="${userr.birthday}"/></p>--%>
<%--&lt;%&ndash;                    <p>${userr.role}</p>&ndash;%&gt;--%>
<%--                </c:if>--%>
<%--                <c:if test="${userLop.index >= 2}">--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${userLop.index == 3}">--%>
<%--                            <p>${userr.name}</p>--%>
<%--                            <p>${userr.login}</p>--%>
<%--                            <p>${userr.password}</p>--%>
<%--                            <c:out value="Половина"/>--%>
<%--                        </c:when>--%>
<%--                        <c:when test="${userLop.index == 4}">--%>
<%--                            <p>${userr.name}</p>--%>
<%--                            <p>${userr.login}</p>--%>
<%--                            <p>${userr.password}</p>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <p>${userr.name}</p>--%>
<%--                            <p>${userr.login}</p>--%>
<%--                            <p>${userr.password}</p>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </c:if>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--    </ol>--%>
<%--</div>--%>
<div><t:footer/></div>
</body>

</html>
