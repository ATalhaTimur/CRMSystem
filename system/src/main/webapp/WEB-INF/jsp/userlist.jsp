<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        body {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 50px;
        }
        table th, table td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-group .btn {
            width: 80px;
        }
        .container {
            max-width: 80%;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center my-4">User List</h2>

    <table class="table table-bordered table-striped text-center align-middle">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Role</th>
            <th>Created At</th>
            <th>Updated At</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>${user.createdAt}</td>
                <td>${user.updatedAt != null ? user.updatedAt : ''}</td>
                <td>
                    <div class="btn-group" role="group">
                        <a href="<c:url value='/users/edit/${user.id}'/>" class="btn btn-warning btn-sm mx-1">Edit</a>
                        <a href="<c:url value='/users/delete/${user.id}'/>" class="btn btn-danger btn-sm mx-1">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="<c:url value='/users/add'/>" class="btn btn-primary">Add New User</a>
    </div>
</div>

</body>
</html>