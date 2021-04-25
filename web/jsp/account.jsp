<%--
  Created by IntelliJ IDEA.
  User: CheeSeWky
  Date: 2020/10/20
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<%String username = (String)session.getAttribute("username");%>
<%String password = (String)session.getAttribute("password"); %>
<%String name = (String)session.getAttribute("name"); %>
<%String gender = (String)session.getAttribute("gender"); %>
<%String birthday = (String)session.getAttribute("birthday"); %>
<%String phone = (String)session.getAttribute("phone"); %>
<%String email = (String)session.getAttribute("email"); %>
<%String address = (String)session.getAttribute("address"); %>

<a href="Index">Home</a>
<a href="CatalogueServlet">Product</a>
<a href="OrderServlet">Order</a>
<a href="AccountServlet">Account</a>
<a href="CartServlet">Cart</a>
<br>

Dear <%=username%>

<br>
<form method="post" action="./ModifyServlet">
    <p><label>Name：</label><input type="text" name="name" value="<%=name%>"></p>
    <p><label>Password：</label><input type="text" name="password" value="<%=password%>" ></p>
    <p><label>Sex：</label><input type="text" name="gender" value="<%=gender%>" ></p>
    <p><label>Birthday：</label><input type="text" name="birthday" value="<%=birthday%>" ></p>
    <p><label>Phone : </label><input type="text" name="phone" value="<%=phone%>"></p>
    <p><label>Email：</label><input type="text" name="email" value="<%=email%>" ></p>
    <p><label>Address：</label><input type="text" name="address" value="<%=address%>" ></p>
    <div class="txt"><input type="submit" value="Save"/></div>
</form>
<a href="LogoutServlet"><button>Log out</button></a>
</body>
</html>
