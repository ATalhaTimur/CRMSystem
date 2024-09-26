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
</head>
<body>
<h2>Customer Form</h2>

<form action="<c:url value='/customer/save'/>" method="post">
    <input type="hidden" name="id" value="${customer.id}"/>

    <label>First Name:</label>
    <input type="text" name="firstName" value="${customer.firstName}"/><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" value="${customer.lastName}"/><br>

    <label>Email:</label>
    <input type="text" name="email" value="${customer.email}"/><br>

    <label>Region:</label>
    <input type="text" name="region" value="${customer.region}"/><br>

    <label>Registration Date:</label>
    <input type="date" name="registrationDate" value="${customer.registrationDate}"/><br>

    <label>Updated At:</label>
    <input type="text" name="updatedAt" value="${customer.updatedAt}" readonly/><br>

    <input type="submit" value="Save"/>
</form>

<a href="<c:url value='/customers'/>">Back to List</a>

</body>
</html>