<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 23/10/2024
  Time: 05:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách loại thuốc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-center">Danh sách loại thuốc</h2>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="listThuocByLoai">
        <select class="form-select" name="idLoaiThuoc" aria-label="Chọn loại thuốc">
            <c:forEach var="loaiThuoc" items="${loaiThuocs}">
                <option value="${loaiThuoc.id}">${loaiThuoc.tenloai}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-primary mt-2">Hiển thị thuốc</button>
    </form>
    <div id="thuocList">
        <c:if test="${not empty thuocs}">
            <h3>Danh sách thuốc</h3>
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
        </c:if>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
