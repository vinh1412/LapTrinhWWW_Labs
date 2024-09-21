<%@ page import="vn.edu.iuh.fit.services.AccountService" %>
<%@ page import="vn.edu.iuh.fit.services.RoleService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 19/09/2024
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<%
    AccountService accountService = new AccountService();
    RoleService roleService = new RoleService();
    String error = request.getAttribute("error") == null ? "" : request.getAttribute("error").toString();
    String success = request.getAttribute("success") == null ? "" : request.getAttribute("success").toString();
    String accountId = session.getAttribute("accountId").toString();
    String user = accountService.findAccountById(accountId).getFullName();
    if (error != null && error.isEmpty()) {
%>
<div class="alert alert-danger" role="alert">
    <%=error%>
</div>
<%
    }
    if (success != null && success.isEmpty()) {
%>
<div class="alert alert-success" role="alert">
    <%=success%>
</div>
<%}%>
<div class="container">
    <h1>Dashboard</h1>
    <div class="d-flex justify-content-between mb-2">
        <h4>Welcome, <%= user %>
        </h4>
        <a href="controller?action=logout" class="btn btn-primary">Logout</a>
    </div>
    <%
        if (roleService.isAdministrator(accountId)) {
    %>
    <h2>Account List</h2>
    <a href="controller?action=add" class="btn btn-primary mb-2">Add New</a>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="filterByRole">
        <div class="form-group">
            <label for="roleSelect">Filter by Role:</label>
            <select id="roleSelect" name="roleId" class="form-control" onchange="this.form.submit()">
                <option value="">Select Role</option>
                <%
                    List<String> roles = roleService.findAll();
                    for (String role : roles) {
                %>
                <option value="<%= role %>" <%= request.getParameter("roleId") != null && request.getParameter("roleId").equals(role) ? "selected" : "" %>><%= role %></option>
                <%
                    }
                %>
            </select>
        </div>
    </form>
    <%}%>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="table-info">
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Status</th>
                <th>Roles</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                String selectedRole = request.getParameter("roleId");
                List<Account> accounts = (selectedRole == null || selectedRole.isEmpty())
                    ? accountService.findAll()
                    : accountService.findAccountByRoleName(selectedRole);
                if (!roleService.isAdministrator(accountId)){
                    accounts=new ArrayList<>();
                    accounts.add(accountService.findAccountById(accountId));
                }
                for (Account account : accounts) {
            %>
            <tr>
                <td><%= account.getAccountId() %></td>
                <td><%= account.getFullName() %></td>
                <td><%= account.getPassword() %></td>
                <td><%= account.getPhone() %></td>
                <td><%= account.getEmail() %></td>
                <td><%= account.getStatus() ==1?"Active": account.getStatus()==0?"Inactive":"Deleted" %></td>
                <td>
                    <%
                        List<String> roles = roleService.findRoleByAccountId(account.getAccountId());
                        for (String role : roles) {
                    %>
                    <span class="badge bg-primary"><%= role %></span>
                    <%
                        }
                    %>
                </td>
                <td>
                    <a href="controller?action=update&accountId=<%= account.getAccountId() %>" class="btn btn-warning">Edit</a>
                    <%
                        if (roleService.isAdministrator(accountId)) {
                    %>
                    <a href="controller?action=delete&accountId=<%= account.getAccountId() %>" class="btn btn-danger">Delete</a>
                    <a href="controller?action=grantRole&accountId=<%= account.getAccountId() %>" class="btn btn-success">Grant Role</a>
                    <%
                        }
                    %>
                <%}%>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
