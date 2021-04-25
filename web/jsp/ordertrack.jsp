<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/22
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OrderTrack</title>
</head>
<body>
<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>
<br>

<table>
    <tr>
        <th>Product Name</th>

    </tr>
    <c:forEach items="${orderItems}" var="orderItems">
        <tr>
            <td>${orderItems.product_name}</td>

    </c:forEach>
</table>

</body>
</html>
