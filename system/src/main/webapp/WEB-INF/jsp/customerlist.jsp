<%--
  Created by IntelliJ IDEA.
  User: talhatimur
  Date: 26.09.2024
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h2>Customer List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Region</th>
        <th>Registration Date</th>
        <th>Updated At</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.region}</td>
            <td>${customer.registrationDate}</td>
            <td>${customer.updatedAt}</td>
            <td>
                <a href="<c:url value='/customer/edit/${customer.id}'/>">Edit</a> |
                <a href="<c:url value='/customer/delete/${customer.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="<c:url value='/customer/add'/>">Add New Customer</a>

</body>
</html>