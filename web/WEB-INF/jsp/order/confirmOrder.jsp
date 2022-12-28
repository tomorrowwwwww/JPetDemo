<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<div id="BackLink" align="right">
    <a href="mainForm">Return to Main Menu</a>
</div>
<div id="Catalog">
    <div id="orderStep2">
        <p1>
            Now it's time to confirm the order
        </p1>
        <p2>Please confirm the information below</p2>
        <p3>If there is no problem, please press continue</p3>
        <p4>Then an order will be generated, So please check carefully</p4>
        <table>
            <tr>
                <th align="center" colspan="2"><font size="4"><b>Order</b></font>
                    <br />
                    <font size="3"><b> <fmt:formatDate
                            value="${sessionScope.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
                </th>
            </tr>

            <tr>
                <th colspan="2">Billing Address</th>
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
                <th colspan="2">Shipping Address</th>
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
            <button><a href="submitOrder" class="Button">Confirm</a></button>
</div>
<%@ include file="../common/bottom.jsp"%>
