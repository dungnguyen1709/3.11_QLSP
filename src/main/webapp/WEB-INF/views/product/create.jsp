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
    <title>Create new product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .message{
            color: darkgreen;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Create new product</h1>
    <p>
        <c:if test="${requestScope['message'] != null}">
            <span class="message">${requestScope['message']}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to product</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><input type="text" name="brand" id="brand"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
