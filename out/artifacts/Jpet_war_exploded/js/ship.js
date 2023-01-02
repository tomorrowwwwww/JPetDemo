
    function shippingShow(checkbox) {
    var Shipping = document.getElementById("Ship");
    if(checkbox.checked){
    Shipping.innerHTML = "<table id='table-3'>\n" +
    "\t<tr>\n" +
    "\t\t<td colspan=2>Shipping Address</td>\n" +
    "\t</tr>\n" +
    "\t<tr>\n" +
    "\t\t<td>First name:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" name=\"order.shipToFirstName\" value=\"${sessionScope.order.shipToFirstName}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Address 1:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"40\" name=\"order.shipAddress1\" value=\"${sessionScope.order.shipAddress1}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Address 2:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"40\" name=\"order.shipAddress2\" value=\"${sessionScope.order.shipAddress2}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>City:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\"  name=\"order.shipCity\" value=\"${sessionScope.order.shipCity}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>State:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"4\" name=\"order.shipState\" value=\"${sessionScope.order.shipState}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Zip:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"10\" name=\"order.shipZip\" value=\"${sessionScope.order.shipZip}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Country:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"10\" name=\"order.shipCountry\" value=\"${sessionScope.order.shipCountry}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n"
}
    else {
    Shipping.innerHTML = "<table id='table-4'>\n" +
    "\t<tr>\n" +
    "\t\t<td colspan=2>Shipping Address</td>\n" +
    "\t</tr>\n" +
    "\t<tr>\n" +
    "\t\t<td>First name:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" name=\"order.billToFirstName\" value=\"${sessionScope.order.billToFirstName}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Address 1:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"40\" name=\"order.billAddress1\" value=\"${sessionScope.order.billAddress1}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Address 2:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"40\" name=\"order.billAddress2\" value=\"${sessionScope.order.billAddress2}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>City:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\"  name=\"order.billCity\" value=\"${sessionScope.order.billCity}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>State:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"4\" name=\"order.billState\" value=\"${sessionScope.order.billState}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Zip:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"10\" name=\"order.billZip\" value=\"${sessionScope.order.billZip}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n" +

    "\t<tr>\n" +
    "\t\t<td>Country:</td>\n" +
    "\t\t<td>\n" +
    "\t\t\t<input type=\"text\" size=\"10\" name=\"order.billCountry\" value=\"${sessionScope.order.billCountry}\"/>\n" +
    "\t\t</td>\n" +
    "\t</tr>\n"
}

}
