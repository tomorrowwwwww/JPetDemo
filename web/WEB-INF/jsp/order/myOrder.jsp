<%@ page import="csu.web.mypetstore.domain.Account" %>
<%@ include file="../common/top.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>What you have order</title>
</head>
<body>
<%
    session.setAttribute("cart", Account.cart1);
%>
<h2>Shopping Cart</h2>

<form action="updateCart" method="post">
    <table>
        <tr>
            <th><b>Item ID</b></th>
            <th><b>Product ID</b></th>
            <th><b>Description</b></th>
            <th><b>In Stock?</b></th>
            <th><b>Quantity</b></th>
            <th><b>List Price</b></th>
            <th><b>Total Cost</b></th>
            <th>&nbsp;</th>
        </tr>

        <c:if test="${Account.cart1.numberOfItems == 0}">
            <tr>
                <td colspan="8"><b>Your have ordered nothing</b></td>
            </tr>
        </c:if>

        <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
            <tr>
                <td>
                    <a href="itemForm?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
                </td>
                <td>${cartItem.item.productId}</td>
                <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                        ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                        ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
                <td>${cartItem.inStock}</td>
                <td>
                    <input type="text" size="3" name="${cartItem.item.itemId}"
                           value="${cartItem.quantity}" />
                </td>
                <td>${cartItem.item.listPrice}</td>
                <td>${cartItem.total}</td>
                <td>
                    <a class="Button" href="removeCartItem?cartItem=${cartItem.item.itemId}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</div>
</body>
</html>

<%@ include file="../common/bottom.jsp"%>