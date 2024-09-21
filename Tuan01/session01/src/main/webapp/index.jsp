<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 19/09/2024
  Time: 02:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="header">
    <h1>Login</h1>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" name="us" id="username">
        <br>
        <label for="password">Password:</label>
        <input type="text" name="psw" id="password">
        <br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
