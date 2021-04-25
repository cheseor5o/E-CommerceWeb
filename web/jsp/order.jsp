<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/21
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
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
        <th>OrderId</th>
        <th>Total Price</th>
        <th>Date</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${orders}" var="orders">
        <tr>
            <td>${orders.order_id}</td>
            <td>${orders.order_total_price}</td>
            <td>${orders.create_time}</td>
            <td>${orders.status}</td>
            <td><a href="OrderTrackServlet?order_id=${orders.order_id}"><button>track</button></a></td>
            <td><a href="OrderRefundServlet?order_id=${orders.order_id}"><button>refund</button></a></td>
            <td><a href="OrderReceiveServlet?order_id=${orders.order_id}"><button>receive</button></a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
