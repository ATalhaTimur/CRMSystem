<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
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
            align-items: flex-start; /* Üstte başlamak için ayar */
            padding-top: 50px; /* Sayfanın üstünden boşluk bırak */
        }
        table th, table td {
            text-align: center; /* Tüm hücreleri yatay olarak ortala */
            vertical-align: middle; /* Hücreleri dikey olarak ortala */
        }
        .action-btn {
            width: 80px; /* Düğmelerin genişliğini eşit yap */
        }
        .container {
            max-width: 80%; /* Genişliği sınırla */
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center my-4">Customer List</h2>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
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
                    <div class="btn-group" role="group">
                        <a href="<c:url value='/customer/edit/${customer.id}'/>" class="btn btn-warning btn-sm action-btn">Edit</a>
                        <a href="<c:url value='/customer/delete/${customer.id}'/>" class="btn btn-danger btn-sm action-btn">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="<c:url value='/customer/add'/>" class="btn btn-primary">Add New Customer</a>
    </div>
</div>

</body>
</html>