<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6 col-sm-12">
            <h2 class="text-center mb-4">User Form</h2>

            <form action="${pageContext.request.contextPath}/users/save" method="post" class="needs-validation" novalidate>
                <input type="hidden" name="id" value="${user.id}"/>

                <!-- Username Field -->
                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" name="username" value="${user.username}" class="form-control" id="username" required/>
                    <div class="invalid-feedback">
                        Please enter a username.
                    </div>
                </div>

                <!-- Password Field -->
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" value="${user.password}" class="form-control" id="password" required minlength="6"/>
                    <div class="invalid-feedback">
                        Please enter a password (at least 6 characters).
                    </div>
                </div>

                <!-- Role Field as Dropdown -->
                <div class="mb-3">
                    <label for="role" class="form-label">Role:</label>
                    <select name="role" class="form-select" id="role" required>
                        <option value="" disabled selected>Select a role</option>
                        <option value="USER" ${user.role == 'USER' ? 'selected' : ''}>USER</option>
                        <option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
                    </select>
                    <div class="invalid-feedback">
                        Please select a role.
                    </div>
                </div>

                <!-- Region Field with 7 Continents -->
                <div class="mb-3">
                    <label for="region" class="form-label">Region:</label>
                    <select name="region" id="region" class="form-select" required>
                        <option value="" disabled selected>Select a region</option>
                        <option value="Africa" ${user.region == 'Africa' ? 'selected' : ''}>Africa</option>
                        <option value="Antarctica" ${user.region == 'Antarctica' ? 'selected' : ''}>Antarctica</option>
                        <option value="Asia" ${user.region == 'Asia' ? 'selected' : ''}>Asia</option>
                        <option value="Europe" ${user.region == 'Europe' ? 'selected' : ''}>Europe</option>
                        <option value="North America" ${user.region == 'North America' ? 'selected' : ''}>North America</option>
                        <option value="Australia" ${user.region == 'Australia' ? 'selected' : ''}>Australia</option>
                        <option value="South America" ${user.region == 'South America' ? 'selected' : ''}>South America</option>
                    </select>
                    <div class="invalid-feedback">
                        Please select a region.
                    </div>
                </div>

                <!-- Submit and Back Buttons -->
                <div class="d-flex justify-content-between">
                    <a href="<c:url value='/users'/>" class="btn btn-secondary btn-lg">Back to List</a>
                    <input type="submit" value="Save" class="btn btn-success btn-lg"/>
                </div>
            </form>
        </div>
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