<%@ include file="../common/top.jsp"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

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

    <h2 align="center" style="font-size:30px;"><b>${sessionScope.category.name}</b></h2>

    <table>
        <tr>
            <td>Product ID</td>
            <td>Name</td>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
                <td>
                    <a href="productForm?productId=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>

<%@ include file="../common/bottom.jsp"%>
