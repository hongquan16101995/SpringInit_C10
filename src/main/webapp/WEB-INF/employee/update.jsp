<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/17/2023
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form update</h1>
<form action="/employees/update" method="post">
    <input type="text" name="id" value="${employee.id}" hidden>
    <label>Name: <input type="text" name="name" value="${employee.name}"></label>
    <label>Age: <input type="text" name="age" value="${employee.age}"></label>
    <label>Salary: <input type="text" name="salary" value="${employee.salary}"></label>
    <label>Address: <input type="text" name="address" value="${employee.address}"></label>
    <button type="submit">Update</button>
</form>
</body>
</html>
