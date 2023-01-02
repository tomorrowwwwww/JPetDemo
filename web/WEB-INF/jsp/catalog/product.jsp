<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ include file="../common/top.jsp"%>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<div class="return">
<div id="BackLink">
    <a href="categoryForm?categoryId=${sessionScope.category.categoryId}">Return to ${sessionScope.category.name}</a>
</div>
</div>
<div class="table-1" align="center">


    <h2 align="center" style="font-size:30px;"><b>${sessionScope.product.name}</b></h2>

<div >
    <table>
        <tr>
            <td>Item ID</td>
            <td>Product ID</td>
            <td>Item Name</td>
            <td>List Price</td>
            <td>&nbsp;</td>
        </tr>
        <c:forEach var="item" items="${sessionScope.itemList}">
            <tr>
                <td>
                    <a href="itemForm?itemId=${item.itemId}">${item.itemId}</a>
                </td>
                <td>${product.productId}</td>
                <td>
                        ${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
                </td>
                <td>
                    <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0,00" />
                </td>
                <td>
                    <a href="addItemToCart?workingItemId=${item.itemId}" class="Button">Add to cart</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>


<%@ include file="../common/bottom.jsp"%>





