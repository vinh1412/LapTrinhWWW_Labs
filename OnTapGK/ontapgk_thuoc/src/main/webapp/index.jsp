<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 23/10/2024
  Time: 03:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-center">Danh sách thuốc</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên thuốc</th>
            <th>Giá</th>
            <th>Năm sản xuất</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="thuoc" items="${thuocs}">
            <tr>
                <td>${thuoc.id}</td>
                <td>${thuoc.tenthuoc}</td>
                <td>${thuoc.gia}</td>
                <td>${thuoc.namsx}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="controller?action=listLoaiThuoc" class="btn btn-primary">Danh sách các loại thuốc</a>
    <a href="addThuoc.jsp" class="btn btn-primary">Thêm thuốc</a>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
