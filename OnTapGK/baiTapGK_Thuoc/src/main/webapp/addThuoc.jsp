<%@ page import="vn.edu.iuh.fit.entities.Loaithuoc" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 24/10/2024
  Time: 03:17 PM
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
<%
    String action = request.getParameter("action");
    List<Loaithuoc> loaiThuocs = (List<Loaithuoc>) request.getAttribute("danhSachLoaiThuoc");
    if (loaiThuocs == null) {
        loaiThuocs = new ArrayList<>();
    }
%>
<div class="container">
    <h2 class="text-center">Thêm thuốc</h2>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <div class="mb-3">
            <label for="name" class="form-label">Tên thuốc</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Năm SX</label>
            <input type="text" class="form-control" id="quantity" name="namSX">
        </div>
        <div class="mb-3">
            <label for="idLoaiThuoc" class="form-label">Loai thuoc</label>
            <select class="form-select" id="idLoaiThuoc" name="idLoaiThuoc">
                <%
                    for (Loaithuoc loaiThuoc : loaiThuocs) {
                %>
                <option value="<%=loaiThuoc.getId()%>"><%=loaiThuoc.getTenloai()%></option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
