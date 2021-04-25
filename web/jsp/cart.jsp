<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/20
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<%Integer total_price = (Integer) session.getAttribute("total_price"); %>

<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>
<br>


<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Num</th>
        <th>Total price</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${cartItems}" var="cartItems">
        <tr>
            <td>${cartItems.product_name}</td>
            <td>${cartItems.base_price}</td>
            <td>${cartItems.num}</td>
            <td>${cartItems.total_price}</td>
            <td>${cartItems.update_time}</td>
            <td><a href="DeleteCartServlet?cart_item_id=${cartItems.cart_item_id}"><button>Delete</button></a></td>
        </tr>
    </c:forEach>
</table>
<a>Total Price:${total_price}</a>
<form action="./CheckoutServlet" method="post">
    <button value="checkout">Check out</button>
</form>
</body>
</html>
