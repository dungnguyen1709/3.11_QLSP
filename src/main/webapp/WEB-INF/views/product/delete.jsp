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
    <title>Delete product</title>
</head>
<body>
<div class="container">
    <h1>Delete product</h1>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
            <table class="table table-danger">
                <tr>
                    <td>Id:</td>
                    <td>${requestScope["product"].getId()}</td>
                </tr>

                <tr>
                    <td>Name:</td>
                    <td>${requestScope["product"].getName()}</td>
                </tr>

                <tr>
                    <td>Price:</td>
                    <td>${requestScope["product"].getPrice()}</td>
                </tr>

                <tr>
                    <td>Description:</td>
                    <td>${requestScope["product"].getDescription()}</td>
                </tr>

                <tr>
                <td>Brand:</td>
                <td>${requestScope["product"].getBrand()}</td>
                </tr>

                <tr>
                    <td><input type="submit" value="Delete product"></td>
                    <td><a href="/products">Back to product list</a> </td>
                </tr>

            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
