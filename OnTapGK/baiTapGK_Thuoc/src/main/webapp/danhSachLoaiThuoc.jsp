<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Loaithuoc" %>
<%@ page import="vn.edu.iuh.fit.entities.Thuoc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <a href="index.jsp" class="btn btn-outline-primary">Back to Home</a>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="listThuocByLoai">
        <select class="form-select" name="idLoaiThuoc" aria-label="Chọn loại thuốc">
            <option value="0" selected>All</option>
            <%
                List<Loaithuoc> loaithuocs = (List<Loaithuoc>) request.getAttribute("danhSachLoaiThuoc");
                for (Loaithuoc loaithuoc : loaithuocs) {
            %>
            <option value="<%=loaithuoc.getId()%>"><%=loaithuoc.getTenloai()%></option>
            <%
                }
            %>
        </select>
        <button type="submit" class="btn btn-primary mt-2">Hiển thị thuốc</button>
    </form>
    <!-- Hiển thị danh sách thuốc -->
    <table class="table table-bordered mt-3">
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
            List<Thuoc> thuocs = (List<Thuoc>) request.getAttribute("thuocs");
            if (thuocs != null && !thuocs.isEmpty()) {
                // Nếu có thuốc, hiển thị từng thuốc trong danh sách
                for (Thuoc thuoc : thuocs) {
        %>
        <tr>
            <td><%=thuoc.getId()%></td>
            <td><%=thuoc.getTenthuoc()%></td>
            <td><%=thuoc.getGia()%></td>
            <td><%=thuoc.getNamsx()%></td>
        </tr>
        <%
            }
        } else {
        %>
        <!-- Nếu không có thuốc, hiển thị thông báo -->
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