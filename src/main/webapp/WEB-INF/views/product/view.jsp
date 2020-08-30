<%--
  Created by IntelliJ IDEA.
  User: LapTop
  Date: 8/30/2020
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<html>
<head>
    <title>View product</title>
</head>
<body>
<div class="container">
    <h1>Product details</h1>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${requestScope['product'].getName()}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${requestScope['product'].getPrice()}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${requestScope['product'].getDescription()}</td>
        </tr>
        <tr>
            <td>Brand:</td>
            <td>${requestScope['product'].getBrand()}</td>
        </tr>
    </table>
</div>

</body>
</html>
