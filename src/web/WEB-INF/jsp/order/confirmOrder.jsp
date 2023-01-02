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
<div class="table-1" align="center">
    <div id="orderStep2">
        <table>
            <tr>
                <td align="center" colspan="2"><font size="4"><b>Order</b></font>
                    <br />
                    <font size="3"><b> <fmt:formatDate
                            value="${sessionScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
                </td>
            </tr>
            <tr>
                <td colspan="2">Billing Address</td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><c:out value="${sessionScope.order.billToFirstName}" /></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><c:out value="${sessionScope.order.billToLastName}" /></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><c:out value="${sessionScope.order.billAddress1}" /></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><c:out value="${sessionScope.order.billAddress2}" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><c:out value="${sessionScope.order.billCity}" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><c:out value="${sessionScope.order.billState}" /></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><c:out value="${sessionScope.order.billZip}" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><c:out value="${sessionScope.order.billCountry}" /></td>
            </tr>
            <tr>
                <td colspan="2">Shipping Address</td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><c:out value="${sessionScope.order.shipToFirstName}" /></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><c:out value="${sessionScope.order.shipToLastName}" /></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><c:out value="${sessionScope.order.shipAddress1}" /></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><c:out value="${sessionScope.order.shipAddress2}" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><c:out value="${sessionScope.order.shipCity}" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><c:out value="${sessionScope.order.shipState}" /></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><c:out value="${sessionScope.order.shipZip}" /></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><c:out value="${sessionScope.order.shipCountry}" /></td>
            </tr>

        </table>

</div>

        <button class="b">
            <a href="submitOrder" class="Button">Confirm</a>
        </button>



<%--    <button id="butt"><a href="submitOrder" class="Button" >Confirm</a></button>--%>
</div>

</body>
