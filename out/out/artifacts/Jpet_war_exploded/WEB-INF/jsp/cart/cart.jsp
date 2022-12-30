<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>



<head>
  <meta charset="UTF-8">
  <title>ShoppigCart</title>
  <link rel="stylesheet" type="text/css" href="css/cart.css">
<%--  <script>--%>
<%--    function updateCart(Id)--%>
<%--    {--%>
<%--      var x = document.getElementById(Id).value;--%>
<%--      sendRequest("UpdateCart?quantity="+ x +"&ID="+Id);--%>
<%--      location.reload();--%>
<%--    }--%>
<%--  </script>--%>
</head>
<body>
<div class="return">
<div id="BackLink" >
  <a href="mainForm">Return to Main Menu</a>
</div>
</div>
<div class="table-1" align="center">
  <h2 align="center" style="font-size:30px;"><b>Shopping Cart</b></h2>
  <div>

      <table border="1" align="center" margin="auto" text-align:="center" vertical-align="middle" cellspacing="0" cellpadding="0" >
<%--        <caption align="center" style="font-size:30px;"><b>Shopping Cart</b></caption>--%>
<%--        &nbsp;&nbsp;&nbsp;--%>
        <tr>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">Item ID</td>
          <td width="100" style="border:1px solid black;vertical-align: middle;text-align: center;">Product ID</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">Description</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">In Stock?</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">Quantity</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">List Price</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">Total Cost</td>
          <td width="80" style="border:1px solid black;vertical-align: middle;text-align: center;">&nbsp;</td>
        </tr>

        <c:if test="${sessionScope.cart.numberOfItems == 0}">
          <tr>
            <td colspan="8"><b>Your cart is empty.</b></td>
          </tr>
        </c:if>

        <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
          <tr>
            <td>
              <a href="itemForm?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
            </td>
            <td>${cartItem.item.product.productId}</td>
            <td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
                ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                ${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
            <td>${cartItem.inStock}</td>

            <td>
              <input type="text" id="quantity" class="quantity" name="${cartItem.item.itemId}" value="${cartItem.quantity}"/>
            </td>
            <script type="text/javascript" src="../js/updateCart.js"></script>
<%--            <script type="text/javascript" src="${pageContext.request.contextPath }/js/updateCart.js"></script>--%>

            <td><fmt:formatNumber value="${cartItem.item.listPrice}"
                                  pattern="$#,##0.00" /></td>
            <td class="totalPrice"><fmt:formatNumber value="${cartItem.total}"
                                                     pattern="$#,##0.00" /></td>
            <td>
              <a href="removeCartItem?workingItemId=${cartItem.item.itemId}" class="button" >Remove</a>
            </td>
          </tr>
        </c:forEach>
        <tr>
          <td colspan="7" id="subtotal">
            Sub Total: <fmt:formatNumber value="${sessionScope.cart.subTotal}" pattern="$#,##0.00" />
          </td>
          <td>
<%--              <input type="submit" οnclick="window.location.href('updateCartQuantities')" value="Update Cart">--%>
                <input type="submit" value="Update Cart" name="updateCartQuantities">
<%--            <input type="submit" name="updateCartQuantities" value="Update Cart" />--%>
          </td>
        </tr>
      </table>

  <c:if test="${sessionScope.cart.numberOfItems > 0 }">
      <a href="newOrderForm" class="Button" id="button">Proceed to Checkout</a>
  </c:if>
  </div>

  <div id="Separator">&nbsp;</div>

</div>
</body>

<%@ include file="../common/bottom.jsp"%>
