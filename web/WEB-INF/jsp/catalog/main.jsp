<%@ include file="../common/top.jsp"%>
<div class="font">
    <h1>
        &nbsp &nbsp &nbsp &nbsp &nbsp Welcome <br>
        &nbsp &nbsp &nbsp &nbsp to our <br>
        &nbsp &nbsp  Petstore!

    </h1>
</div>
<div id="navv">
    <div class="menu">
        <ul>
            <li><a href="categoryForm?categoryId=REPTILES">Reptiles</a></li>
            <li><a href="categoryForm?categoryId=DOGS">Dogs</a></li>
            <li><a href="categoryForm?categoryId=CATS">Cats</a></li>
            <li><a href="categoryForm?categoryId=BIRDS">Birds</a></li>
            <li><a href="categoryForm?categoryId=FISH">Fish</a></li>
        </ul>
    </div>
</div>

<div id="searchMsg">
    <c:if test="${requestScope.searchMsg!=null }">
        <p><font color="white" >${requestScope.searchMsg}</font></p>
    </c:if>
</div>


<c:if test="${sessionScope.productList!=null&&sessionScope.keyword!=null}">
    <form action="productForm" method="post">
        <div id="searchlist">
            <c:forEach var="product" items="${sessionScope.productList}">
                <input type="submit" style="display:block;" name="name" value="${product.name}"></input>
            </c:forEach>
        </div>
    </form>
</c:if>



<%@ include file="../common/bottom.jsp"%>