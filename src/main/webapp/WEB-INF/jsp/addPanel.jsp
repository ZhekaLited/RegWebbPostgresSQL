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
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
    <t:add/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Add-Users</title>
<body>
<div class="d29">
    <h1 class="logo-title">Add User</h1>
    <form action="<%=request.getContextPath()%>/addPanel" method="post">
        <div class="form-dts">
            <input class="window-write" type="text" name="login" placeholder="Login" required>
            <input class="window-write" type="text" name="password" placeholder="Password" required>
            <input class="window-write" type="text" name="salary" placeholder="Salary" required>
            <input class="window-write" type="text" name="name" placeholder="Name" required>
            <input class="window-write" type="text" name="birthday" placeholder="Birthday: dd.mm.yyyy" required>

            <div class="icon-item">

                <select class="selectpicker" name="roles" multiple data-width="50%">>
                    <option name="role" value="Admin">ADMIN</option>
                    <option name="role" value="User">USER</option>
                    <option name="role" value="Author">AUTHOR</option>
                    <option name="role" value="Manager">MANAGER</option>
                    <option name="role" value="Editor">EDITOR</option>
                </select>
            </div>
        </div>


        <div class="btn-group">
            <label class="erorr">${ShowError}</label>
            <button class="button">ADD</button>
        </div>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/js/bootstrap-select.min.js"></script>

</body>

</html>
