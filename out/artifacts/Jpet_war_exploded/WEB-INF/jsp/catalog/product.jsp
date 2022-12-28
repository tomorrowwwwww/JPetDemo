<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ include file="../common/top.jsp"%>

<div id="BackLink">
    <a href="categoryForm?categoryId=${sessionScope.category.categoryId}">Return to ${sessionScope.category.name}</a>
</div>

<div id="Product">

    <h2>${sessionScope.product.name}</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Item Name</th>
            <th>List Price</th>
            <th>&nbsp;</th>
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
<%--                <td>${sessionScope.product.description}</td>--%>
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

<%@ include file="../common/bottom.jsp"%>





