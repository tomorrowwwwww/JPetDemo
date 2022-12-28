<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>
<div id="BackLink" align="right">
    <a href="mainForm">Return to Main Menu</a>
</div>
<div id="Catalog">
    <div id="orderStep1" >
        <form id="form1" action="newOrder" method="post">
            <table>
                <tr>
                    <th colspan=2>Payment Details</th>
                </tr>
                <tr>
                    <td>Card Type:</td>
                    <td><select name="order.cardType">
                        <option selected="selected" value="Visa">Visa</option>
                        <option value="MasterCard">MasterCard</option>
                        <option value="American Express">American Express</option>
                    </select></td>
                    </select></td>
                </tr>
                <tr>
                    <td>Card Number:</td>
                    <td><input name="order.creditCard" value="999 9999 9999 9999" type="text" /> * Use a fake
                        number!</td>
                </tr>
                <tr>
                    <td>Expiry Date (MM/YYYY):</td>
                    <td><input name="order.expiryDate" value="12/2022" type="text"></td>
                </tr>

            </table>
            </br>
            <div id="tab" align="left">
                <ul>
                    <li id="billingLi" class="on">Billing Address</li>
                    <li id="shippingLi">Shipping Address</li>
                </ul>
                </br>
                <div id="billing" style="display: inline;">
                    <table>
                        <tr>
                            <th colspan=2>Billing Address</th>
                        </tr>

                        <tr>
                            <td>First name:</td>
                            <td><input name="order.billToFirstName" value="${sessionScope.order.shipToFirstName}" type="text"></td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td><input name="order.billToLastName" value="${sessionScope.order.shipToLastName}" type="text"></td>
                        </tr>
                        <tr>
                            <td>Address 1:</td>
                            <td><input name="order.billAddress1" value="${sessionScope.order.shipAddress1}" type="text" size="40"></td>
                        </tr>
                        <tr>
                            <td>Address 2:</td>
                            <td><input name="order.billAddress2" value="${sessionScope.order.shipAddress2}" type="text" size="40"></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input name="order.billCity" value="${sessionScope.order.shipCity}" type="text"></td>
                        </tr>
                        <tr>
                            <td>State:</td>
                            <td><input name="order.billState" value="${sessionScope.order.shipState}" type="text" size="4"></td>
                        </tr>
                        <tr>
                            <td>Zip:</td>
                            <td><input name="order.billZip" value="${sessionScope.order.shipZip}" type="text" size="10"></td>
                        </tr>
                        <tr>
                            <td>Country:</td>
                            <td><input name="order.billCountry" value="${sessionScope.order.shipCountry}" type="text" size="15"></td>
                        </tr>
                    </table>
                </div>
                <div id="shipping" align="right" style="display: inline;">
                    <table>
                        <tr>
                            <th colspan=2>Shipping Address</th>
                        </tr>
                        <tr>
                            <td>First name:</td>
                            <td><input type="text"  name="order.shipToFirstName" value="${sessionScope.order.shipToFirstName}" /></td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td><input type="text"  name="order.shipToLastName" value="${sessionScope.order.shipToLastName}" /></td>
                        </tr>
                        <tr>
                            <td>Address 1:</td>
                            <td><input type="text"  size="40" name="order.shipAddress1" value="${sessionScope.order.shipAddress1}" /></td>
                        </tr>
                        <tr>
                            <td>Address 2:</td>
                            <td><input type="text"  size="40" name="order.shipAddress2" value="${sessionScope.order.shipAddress2}" /></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input type="text"  name="order.shipCity" value="${sessionScope.order.shipCity}" /></td>
                        </tr>
                        <tr>
                            <td>State:</td>
                            <td><input type="text"  size="4" name="order.shipState" value="${sessionScope.order.shipState}" /></td>
                        </tr>
                        <tr>
                            <td>Zip:</td>
                            <td><input type="text"  size="10" name="order.shipZip" value="${sessionScope.order.shipZip}" /></td>
                        </tr>
                        <tr>
                            <td>Country:</td>
                            <td><input type="text"  size="15" name="order.shipCountry" value="${sessionScope.order.shipCountry}" /></td>
                        </tr>
                    </table>
                </div>
            </div>

            <input id="Continue" type="submit" name="newOrder" value="Continue" class="button"/>
        </form>
    </div>

</div>
<script src="../js/newOrder.js"></script>

