<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/17/2023
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List employee</h1>
<a href="/employees/create">Create new employee</a>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="e" items="${employees}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${e.name}</td>
            <td>${e.age}</td>
            <td>${e.salary}</td>
            <td>${e.address}</td>
            <td><a href="/employees/update/${e.id}">Update</a></td>
            <td><a href="/employees/delete/${e.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
