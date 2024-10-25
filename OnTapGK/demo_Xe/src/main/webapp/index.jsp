<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Xe" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">CUA HANG BAN XE GAN MAY ABC</h1>
    <a href="danhSachXe.jsp">Danh sach xe</a> <span>|</span>
    <a href="controller?action=addXe">Them xe</a>
    <form action="controller" method="get">
        <input type="hidden" name="action" value="findByName">
        <div style="text-align:right">
            <input type="text" name="nameXe" id="nameXe">
            <button type="submit" class="btn btn-primary">Tim kiem</button>
        </div>
    </form>
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
            List<Xe> dsXe = (List<Xe>) request.getAttribute("dsXe");
            for (Xe xe : dsXe) {
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
            <td><a class="btn btn-primary" href="controller?action=editXe&id=<%=xe.getId()%>">Edit</a></td>
            <td><a class="btn btn-primary" href="controller?action=deleteXe&id=<%=xe.getId()%>">Delete</a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<footer>
    <h2 class="text-center">Tran Hien Vinh_21015151_15</h2>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>