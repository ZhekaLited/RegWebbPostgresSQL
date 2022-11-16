<%--
  Created by IntelliJ IDEA.
  User: alen
  Date: 06.11.2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
<head>

    <title>Edit</title>
</head>
<t:headerPanel/>
<body>
<div class="d29">
    <h1 class="logo-title">Edit User</h1>
    <form action="/RegWebb_war_exploded/editPanel" method="post">
        <div class="form-dts">
            <input class="window-write" type="text" name="login" placeholder="Login" value="${login}" required>
            <input class="window-write" type="text" name="password" placeholder="Password" value="${password}" required>
            <input class="window-write" type="text" name="email" placeholder="Email" value="${email}" required>
            <input class="window-write" type="text" name="name" placeholder="Name" value="${name}" required>
            <input class="window-write" type="text" name="surname" placeholder="Surname" value="${surname}" required>
            <input class="window-write" type="text" name="patronymic" placeholder="Patronymic" value="${patronymic}"
                   required>
            <input class="window-write" type="text" name="birthday" placeholder="Birthday: dd.mm.yyyy"
                   value="${birthday}" required>
            <select class="window-write" name="role">
                <option ${selectedUser}>USER</option>
                <option ${selectedAdmin}>ADMIN</option>
            </select>
            <div class="btn-group">
                <button class="button">Edit</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
