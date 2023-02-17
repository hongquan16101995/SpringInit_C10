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
<h1>Form create</h1>
<form action="/employees" method="post">
    <label>Name: <input type="text" name="name"></label>
    <label>Age: <input type="text" name="age"></label>
    <label>Salary: <input type="text" name="salary"></label>
    <label>Address: <input type="text" name="address"></label>
    <button type="submit">Create</button>
</form>
</body>
</html>
