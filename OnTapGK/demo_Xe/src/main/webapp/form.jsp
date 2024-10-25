<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.HangXe" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %><%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 25/10/2024
  Time: 04:09 PM
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
    Xe xe = (Xe) request.getAttribute("xe");
    int maXe = (xe != null && xe.getId() != 0) ? xe.getId() : 0;
    String tenXe = (xe != null && xe.getTenxe() != null) ? xe.getTenxe() : "";
    double giaXe = (xe != null && xe.getGiaxe() != 0) ? xe.getGiaxe() : 0.0;
    int namSanXuat = (xe != null && xe.getNamsanxuat() != 0) ? xe.getNamsanxuat() : 0;
    int idHangXe = (xe != null && xe.getMahangxe() != null && xe.getMahangxe().getId() != 0) ? xe.getMahangxe().getId() : 0;
%>
<div class="container">
    <h1>Form</h1>
    <form action="controller" method="post">
        <input type="hidden" name="action" value="<%=action%>">
        <input type="hidden" name="id" value="<%=maXe%>">
        <div class="mb-3">
            <label for="tenXe" class="form-label">Ten xe</label>
            <input type="text" name="tenXe" id="tenXe" class="form-control" value="<%=tenXe%>" required>
        </div>
        <div class="mb-3">
            <label for="giaXe" class="form-label">Gia xe</label>
            <input type="text" name="giaXe" id="giaXe" class="form-control" value="<%=giaXe%>" required>
        </div>
        <div class="mb-3">
            <label for="namSanXuat" class="form-label">Nam san xuat</label>
            <input type="text" name="namSanXuat" id="namSanXuat" class="form-control" value="<%=namSanXuat%>" required>
        </div>
        <div class="mb-3">
            <section>
                <label for="maHangXe" class="form-label">Ten hang xe</label>
                <select class="form-select" id="maHangXe" name="maHangXe">
                    <%
                        List<HangXe> dsHangXe = (List<HangXe>) request.getAttribute("dsHangXe");
                        if (dsHangXe != null && !dsHangXe.isEmpty()) {
                            for (HangXe hangXe : dsHangXe) {
                                String selected=hangXe.getId().equals(idHangXe)?"selected":"";
                    %>
                    <option value="<%=hangXe.getId()%>" <%=selected%>><%=hangXe.getTenhang()%>
                    </option>
                    <%
                            }
                        }
                    %>
                </select>
            </section>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
        <a class="btn btn-primary" href="controller?action=dsXe">Quay lai</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
