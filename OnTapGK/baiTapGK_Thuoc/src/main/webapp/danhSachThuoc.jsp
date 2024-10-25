<%@ page import="vn.edu.iuh.fit.entities.Thuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 24/10/2024
  Time: 04:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <a href="index.jsp" class="btn btn-outline-primary">Trở về trang chủ</a>
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
        <%
            // Lấy danh sách thuốc từ request
            List<Thuoc> danhSachThuoc = (List<Thuoc>) request.getAttribute("danhSachThuoc");
            if (danhSachThuoc != null && !danhSachThuoc.isEmpty()) {
                // Duyệt danh sách thuốc
                for (Thuoc thuoc : danhSachThuoc) {
        %>
        <tr>
            <td><%= thuoc.getId() %></td>
            <td><%= thuoc.getTenthuoc() %></td>
            <td><%= thuoc.getGia() %></td>
            <td><%= thuoc.getNamsx() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4" class="text-center">Không có thuốc nào trong danh sách.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
