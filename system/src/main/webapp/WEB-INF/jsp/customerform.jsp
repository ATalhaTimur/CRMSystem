<%--
  Created by IntelliJ IDEA.
  User: talhatimur
  Date: 26.09.2024
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">

<div class="row justify-content-center">
    <div class="col-md-8">
        <h2 class="text-center my-4">Customer Form</h2>

        <form action="<c:url value='/customer/save'/>" method="post" class="needs-validation" novalidate>
            <input type="hidden" name="id" value="${customer.id}"/>

            <!-- First Name Field -->
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name:</label>
                <input type="text" name="firstName" class="form-control" id="firstName" value="${customer.firstName}" required/>
                <div class="invalid-feedback">
                    Please enter the first name.
                </div>
            </div>

            <!-- Last Name Field -->
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name:</label>
                <input type="text" name="lastName" class="form-control" id="lastName" value="${customer.lastName}" required/>
                <div class="invalid-feedback">
                    Please enter the last name.
                </div>
            </div>

            <!-- Email Field -->
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" name="email" class="form-control" id="email" value="${customer.email}" required/>
                <div class="invalid-feedback">
                    Please enter a valid email.
                </div>
            </div>

            <!-- Region Field with 7 Continents -->
            <div class="mb-3">
                <label for="region" class="form-label">Region:</label>
                <select name="region" id="region" class="form-select" required>
                    <option value="" disabled selected>Select a region</option>
                    <option value="Africa" ${customer.region == 'Africa' ? 'selected' : ''}>Africa</option>
                    <option value="Antarctica" ${customer.region == 'Antarctica' ? 'selected' : ''}>Antarctica</option>
                    <option value="Asia" ${customer.region == 'Asia' ? 'selected' : ''}>Asia</option>
                    <option value="Europe" ${customer.region == 'Europe' ? 'selected' : ''}>Europe</option>
                    <option value="North America" ${customer.region == 'North America' ? 'selected' : ''}>North America</option>
                    <option value="Australia" ${customer.region == 'Australia' ? 'selected' : ''}>Australia</option>
                    <option value="South America" ${customer.region == 'South America' ? 'selected' : ''}>South America</option>
                </select>
                <div class="invalid-feedback">
                    Please select a region.
                </div>
            </div>

            <!-- Registration Date Field -->
            <div class="mb-3">
                <label for="registrationDate" class="form-label">Registration Date:</label>
                <input type="date" name="registrationDate" class="form-control" id="registrationDate" value="${customer.registrationDate}" required/>
                <div class="invalid-feedback">
                    Please select a registration date.
                </div>
            </div>

            <!-- Updated At Field (Read-Only) -->
            <div class="mb-3">
                <label for="updatedAt" class="form-label">Updated At:</label>
                <input type="text" name="updatedAt" class="form-control" id="updatedAt" value="${customer.updatedAt}" readonly/>
            </div>

            <!-- Submit and Back Buttons -->
            <div class="d-flex justify-content-between">
                <a href="<c:url value='/customers'/>" class="btn btn-secondary btn-lg">Back to List</a>
                <input type="submit" value="Save" class="btn btn-success btn-lg"/>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap Form Validation Script -->
<script>
    (function() {
        'use strict';
        var forms = document.querySelectorAll('.needs-validation');
        Array.prototype.slice.call(forms)
            .forEach(function(form) {
                form.addEventListener('submit', function(event) {
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
    })();
</script>

</body>
</html>