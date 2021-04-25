<%@ page import="vo.Product" %><%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/20
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<%Product product = (Product)session.getAttribute("product"); %>

<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>

<br>

Product name:${product.product_name}
<br>
Product price:${product.price}
<br>
Product descript:${product.descript}
<br>
Product image:<img src="${product.product_thumb}">
<br>
Product Num:

<form action="AddCartServlet?id=${product.product_id}" method="get">
    <input type="text" name="product_num" value="1" >
    <input name="product_id" value="${product.product_id}" hidden>
    <button value="AddCart">Add to cart</button>
</form>

</body>
</html>