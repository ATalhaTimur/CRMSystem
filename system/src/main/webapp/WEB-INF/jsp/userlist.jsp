<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">

<h2 class="text-center my-4">User List</h2>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Role</th>
        <th>Region</th>  <!-- Region alanı eklendi -->
        <th>Created Date</th>
        <th>Created Time</th>
        <th>Updated Date</th>
        <th>Updated Time</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.role}</td>
            <td>${user.region}</td>
            <td>${user.formattedCreatedAtDate}</td>
            <td>${user.formattedCreatedAtTime}</td>
            <td>${user.formattedUpdatedAtDate}</td>
            <td>${user.formattedUpdatedAtTime}</td>
            <td>
                <a href="<c:url value='/users/edit/${user.id}'/>" class="btn btn-warning btn-sm">Edit</a>
                <a href="<c:url value='/users/delete/${user.id}'/>" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="text-center mt-4">
    <a href="<c:url value='/users/add'/>" class="btn btn-primary">Add New User</a>
</div>

</body>
</html>