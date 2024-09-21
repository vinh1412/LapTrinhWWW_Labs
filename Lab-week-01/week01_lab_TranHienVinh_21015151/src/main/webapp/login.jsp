<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 18/09/2024
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container w-25 mt-5">
    <%
        String err = (String) request.getAttribute("error");
        String accountId = (String) request.getAttribute("accountId");
        if (err == null) {
            err = "";
        }
        if (accountId == null) {
            accountId = "";
        }
    %>
    <div class="row">
        <div class="col text-center bg-info text-white">
            <h1>Login</h1>
        </div>
    </div>
    <form action="controller?action=login" class="was-validated" method="post">
        <div  data-mdb-input-init class="mb-3 mt-3">
            <label for="accountId" class="form-label">Username:</label>
            <input type="text" class="form-control" id="accountId" name="us" placeholder="Enter username" required value="<%=accountId%>">
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div data-mdb-input-init class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" name="psw" placeholder="Enter password" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-outline mb-4">
            <p style="color: red"><%= err %>
            </p>
        </div>
        <div class="row mb-3">
            <div class="col-5">
                <input class="form-check-input" type="checkbox" id="myCheck" name="remember" checked>
                <label class="form-check-label" for="myCheck">Remember me</label>
            </div>
            <div class="col-5">
                <a href="#">Forgot password?</a>
            </div>
        </div>
        <div class="d-grid">
            <button type="submit" data-mdb-button-init data-mdb-ripple-init
                    class="btn btn-primary btn-block text-uppercase">Login
            </button>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <a href="#">Create an account</a>
            </div>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>