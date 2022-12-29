<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<div class="return">
<div id="BackLink" align="right">
    <a href="main">Return to Main Menu</a>
</div>
</div>
<div class="table-1" align="center">
    <div id="orderStep1" >
        <form id="form1" action="update" method="post">
            <div id="billing" style="display: inline;">
                <table>
                    <tr>
                        <td>First name:</td>
                        <td><input name="update.FirstName" value="${sessionScope.order.shipToFirstName}" type="text"></td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td><input name="update.LastName" value="${sessionScope.order.shipToLastName}" type="text"></td>
                    </tr>
                    <tr>
                        <td>Address 1:</td>
                        <td><input name="update.Address1" value="${sessionScope.order.shipAddress1}" type="text" size="40"></td>
                    </tr>
                    <tr>
                        <td>Address 2:</td>
                        <td><input name="update.Address2" value="${sessionScope.order.shipAddress2}" type="text" size="40"></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><input name="update.City" value="${sessionScope.order.shipCity}" type="text"></td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td><input name="update.State" value="${sessionScope.order.shipState}" type="text" size="4"></td>
                    </tr>
                    <tr>
                        <td>Zip:</td>
                        <td><input name="update.Zip" value="${sessionScope.order.shipZip}" type="text" size="10"></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td><input name="update.Country" value="${sessionScope.order.shipCountry}" type="text" size="15"></td>
                    </tr>
                </table>
            </div>
            <input id="Continue" type="submit" name="newOrder" value="Finished" class="button"/>
        </form>
    </div>

</div>
</body>
<script src="js/newOrder.js"></script>




