<%--
  Created by IntelliJ IDEA.
  User: Tran Hien Vinh
  Date: 02/10/2024
  Time: 05:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="controller" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="description" placeholder="Description">
    <input type="text" name="img" placeholder="img path">
    <input type="submit" value="Submit">
    <input type="reset" value="Rest">
  </form>
  </body>
</html>
