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
    <title>Add-Users</title>
</head>
<t:headerPanel/>
<body>
<div class="d29">
    <h1 class="logo-title">Add User</h1>
    <form action="/RegWebb_war_exploded/addPanel" method="post">
        <div class="form-dts">
            <input class="window-write" type="text" name="login" placeholder="Login" required>
            <input class="window-write" type="text" name="password" placeholder="Password" required>
            <input class="window-write" type="text" name="email" placeholder="Email" required>
            <input class="window-write" type="text" name="name" placeholder="Name" required>
            <input class="window-write" type="text" name="surname" placeholder="Surname" required>
            <input class="window-write" type="text" name="patronymic" placeholder="Patronymic" required>
            <input class="window-write" type="text" name="birthday" placeholder="Birthday: dd.mm.yyyy" required>
            <select class="window-write" name="role">
                <option>USER</option>
                <option>ADMIN</option>
            </select>
            <div class="btn-group">
                <button class="button">ADD</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
