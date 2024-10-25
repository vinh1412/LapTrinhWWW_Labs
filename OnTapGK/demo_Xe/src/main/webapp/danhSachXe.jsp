<%@ page import="vn.edu.iuh.fit.entities.Xe" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 25/10/2024
  Time: 03:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach xe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">CUA HANG BAN XE GAN MAY ABC</h1>
    <a href="controller?action=dsXe">Quay lai</a>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>Ma xe</th>
            <th>Ten xe</th>
            <th>Gia xe</th>
            <th>Nam san xuat</th>
            <th>Hang xe</th>
        </tr>
        </thead>
        <tbody>
        <%
            Xe xe = (Xe) request.getAttribute("dsXe");
            if (xe!=null){
        %>
        <tr>
            <td><%=xe.getId()%>
            </td>
            <td><%=xe.getTenxe()%>
            </td>
            <td><%=xe.getGiaxe()%>
            </td>
            <td><%=xe.getNamsanxuat()%>
            </td>
            <td><%=xe.getMahangxe().getTenhang()%></td>
        </tr>
        <%}else {%>
        <tr>
            <td colspan="4" class="center">Khong co xe trong danh sach</td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
