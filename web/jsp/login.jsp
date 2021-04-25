<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/21
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>

<br>
<a href="Register">Register</a>
<form action="./LoginServlet" method="post">
    <p><input type="text" name="username" value="" placeholder="username"></p>
    <p><input type="text" name="password" value="" placeholder="password"></p>
    <p><input type="submit" name="Login" value="Log in"></p>
</form>
</body>
</html>
