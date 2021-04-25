<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/20
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>


<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>

<br>

<a href="SubclassServlet?subclass_id=1">catalogue 1</a>
<a href="SubclassServlet?subclass_id=2">catalogue 2</a>
<a href="SubclassServlet?subclass_id=3">catalogue 3</a>

<form action="SearchServlet?search=" method="get">
    <input type="text" name="search" value="" placeholder="Search product">
    <button value="search">search</button>
</form>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Descript</th>
    </tr>
    <c:forEach items="${product_list}" var="product">
        <tr>
            <td><a href="ProductServlet?${product.product_id}">${product.product_name}</a></td>
            <td>${product.price}</td>
            <td>${product.subclass_id}</td>
            <td>${product.descript}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
