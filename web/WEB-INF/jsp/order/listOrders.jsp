<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<div class="return">
<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>
</div>
<div class="table-1">
<h2 align="center" style="font-size:30px;"><b>My Orders</b></h2>

<table>
    <tr>
        <td>Order ID</td>
        <td>Date</td>
        <td>Total Price</td>
    </tr>

<%--    <c:forEach var="order" items="${sessionScope.orderList}">--%>
        <tr>
            <td>
<%--                <a href="order?orderId=${sessionScope.order.orderId}">${sessionScope.order.orderId}</a>--%>
                <a href="submitOrder">${sessionScope.order.orderId}</a>
            </td>
            <td><fmt:formatDate value="${sessionScope.order.orderDate}"
                                pattern="yyyy/MM/dd HH:mm:ss" /></td>
            <td><fmt:formatNumber value="${sessionScope.order.totalPrice}"
                                  pattern="$#,##0.00" /></td>
        </tr>
<%--    </c:forEach>--%>
</table>
</div>
</body>

<%@ include file="../common/bottom.jsp"%>
