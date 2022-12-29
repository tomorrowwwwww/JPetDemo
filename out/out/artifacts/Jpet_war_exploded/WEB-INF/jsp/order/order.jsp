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

<c:if test="${requestScope.msg!=null}">
    <ul class="messages">
        <li>
                ${requestScope.msg}
        </li>
    </ul>
</c:if>
<div class="table-1" align="center">
    <div id="orderStep3">
        <table>
            <tr>
                <td align="center" colspan="2">Order #${sessionScope.order.orderId}
                    <fmt:formatDate value="${sessionScope.order.orderDate}"
                                    pattern="yyyy/MM/dd HH:mm:ss" /></td>
            </tr>
            <tr>
                <td colspan="2">Payment Details</td>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td><c:out value="${sessionScope.order.cardType}" /></td>
            </tr>
            <tr>
                <td>Card Number:</td>
                <td><c:out value="${sessionScope.order.creditCard}" /> * Fake
                    number!</td>
            </tr>
            <tr>
                <td>Expiry Date (MM/YYYY):</td>
                <td><c:out value="${sessionScope.order.expiryDate}" /></td>
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
            <tr>
                <td>Courier:</td>
                <td><c:out value="${sessionScope.order.courier}" /></td>
            </tr>
            <tr>
                <td colspan="2">Status: <c:out value="${sessionScope.order.status}" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <table>
                        <tr>
                            <td>Item ID</td>
                            <td>Description</td>
                            <td>Quantity</td>
                            <td>Price</td>
                            <td>Total Cost</td>
                        </tr>
                        <c:forEach var="lineItem" items="${sessionScope.order.lineItems}">
                            <tr>
                                <td>
                                    <a href="itemForm?itemId=${lineItem.item.itemId}">${lineItem.item.itemId}</a>
                                </td>
                                <td><c:if test="${lineItem.item != null}">
                                    ${lineItem.item.attribute1}
                                    ${lineItem.item.attribute2}
                                    ${lineItem.item.attribute3}
                                    ${lineItem.item.attribute4}
                                    ${lineItem.item.attribute5}
                                    ${lineItem.item.product.name}
                                </c:if>
                                    <c:if test="${lineItem.item == null}">
                                    <i>{description unavailable}</i>
                                </c:if></td>

                                <td>${lineItem.quantity}</td>
                                <td><fmt:formatNumber value="${lineItem.unitPrice}"
                                                      pattern="$#,##0.00" /></td>
                                <td><fmt:formatNumber value="${lineItem.total}"
                                                      pattern="$#,##0.00" /></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="5">Total: <fmt:formatNumber
                                    value="${sessionScope.order.totalPrice}" pattern="$#,##0.00" /></td>
                        </tr>
                    </table>
                </td>
            </tr>

        </table>

    </div>

        <button class="b">
            <a href="myOrdersForm" class="Button">Check order</a>
        </button>

</div>

</body>
<script type="text/javascript">
    $('#progressBar div').css('background', 'linear-gradient(to right, green 50%, green 50%)');
    $('#progressBar>button:nth-child(2)').css('background', 'green');
    $('#progressBar>button:nth-child(3)').css('background', 'green');
</script>

