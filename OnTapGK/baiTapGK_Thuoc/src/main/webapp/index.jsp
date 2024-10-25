<%@ page import="vn.edu.iuh.fit.entities.Thuoc" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Danh sách thuốc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-center">21015151</h2>
    <div class="d-flex justify-content-between mb-2">
        <a href="controller?action=danhSachThuoc" class="btn btn-primary">Danh sách các thuốc</a>
        <a href="controller?action=danhSachLoaiThuoc" class="btn btn-primary">Danh sách các loại thuốc</a>
        <a href="controller?action=themThuoc" class="btn btn-primary">Thêm thuốc</a>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
