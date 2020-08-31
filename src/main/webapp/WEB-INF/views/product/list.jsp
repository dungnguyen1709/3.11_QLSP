<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LapTop
  Date: 8/30/2020
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Products</h1>
    <p>
        <a href="/products?action=create">Create new product</a>
    </p>

    <table class="table table-hover">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Brand</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>

        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getBrand()}</td>
             <td><a href="/products?action=edit&id=${product.getId()}">Edit</a> </td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
