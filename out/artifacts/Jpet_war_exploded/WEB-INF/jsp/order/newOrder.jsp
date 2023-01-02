<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>



<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/neworder.css">
    <script>
        window.onload = function () {
            var tab = document.getElementById('tab');
            //通过id获取tab元素
            var li = tab.getElementsByTagName('li');
            //获取tab元素中的所有li元素
            var card = document.getElementById('card');
            //通过id获取card元素
            var content = card.getElementsByClassName('content');
            //获取card元素下的所有content元素

            for (let i = 0; i < li.length; i++) {//定义一个变量i=0，让其小于li元素的个数
                li[i].onclick = function () {//为每一个li都添加一个onclick点击事件
                    for (let e = 0; e < li.length; e++) {//该for循环使每一个li的class为空content的display为none
                        li[e].className = "";            //每触发点击事件时，会清除之前被点击的li的样式并隐藏之前显示的content
                        content[e].style.display = "none";
                    }
                    li[i].className = "pu";//为li添加一个为up的class
                    content[i].style.display = "block";//使得content的display为block
                }
            }
        }

    </script>
</head>
<body>
<div class="return">
<div id="BackLink">
    <a href="mainForm">Return to Main Menu</a>
</div>
</div>
<div >
    <div>
        <form id="form1" action="newOrder" method="post">
            <div class="table-1" align="center">
            <table>
                <tr>
                    <td colspan=2>Payment Details</td>
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
            <div id="tab" id="tab" align="center">
                <ul class="c">
                    <li><input type="button" id="button1" value="Billing Address" class="active"></li>
                    <li><input type="button" id="button2" value="Shipping Address"></li>
                </ul>
            </div>

            <div class="card" id="card" align="center">
                <div id="billing" class="content" style="display:block;">
                    <table>
                        <tr>
                            <td colspan=2>Billing Address</td>
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

                <div id="shipping" class="content" style="display:block;">
                    <table>
                        <tr>
                            <td colspan=2>Shipping Address</td>
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
                <input id="Continue" type="submit" name="newOrder" value="Continue" />
            </div>
        </form>
    </div>

</div>

</body>





