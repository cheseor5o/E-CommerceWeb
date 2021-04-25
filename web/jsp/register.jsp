<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/21
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>

<br>

<a href="Login">Login</a>
<form action="./RegisterServlet" method="post">
    <p><input type="text" name="username" value="" placeholder="username"></p>
    <p><input type="text" name="password" value="" placeholder="password"></p>
    <p><input type="submit" name="Register" value="Register"></p>
</form>
</body>
</html>
