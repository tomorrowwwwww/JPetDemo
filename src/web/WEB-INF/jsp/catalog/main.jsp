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
    <div id="inform" style="display: none">sssssssssss</div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/showProductInfo.js"></script>
    <div id="MainImage">
        <link rel="stylesheet" type="text/css" href="css/showProductInfo.css">
    <div id="content" class="content">
        <map name="estoremap">
            <area alt="BIRDS" coords="72,2,280,250" href="categoryForm?categoryId=BIRDS" shape="rect"
                  onmouseocver="showInform(alt);" onmouseout="hiddenInform(event)"/>
            <area alt="FISH" coords="2,180,72,250" href="categoryForm?categoryId=FISH" shape="rect"
                  onmouseover="showInform(alt);" onmouseout="hiddenInform(event)"/>
            <area alt="DOGS" coords="60,250,130,320" href="categoryForm?categoryId=DOGS" shape="rect"
                  onmouseover="showInform(alt);" onmouseout="hiddenInform(event)"/>
            <area alt="REPTILES" coords="140,270,210,340" href="categoryForm?categoryId=REPTILES" shape="rect"
                  onmouseover="showInform(alt);" onmouseout="hiddenInform(event)"/>
            <area alt="CATS" coords="225,240,295,310" href="categoryForm?categoryId=CATS" shape="rect"
                  onmouseover="showInform(alt);" onmouseout="hiddenInform(event)"/>
            <area alt="BIRDS" coords="280,180,350,250" href="categoryForm?categoryId=BIRDS" shape="rect"
                  onmouseover="showInform(alt);" onmouseout="hiddenInform(event)"/>
        </map>
        <img height="355" src="images/splash.png" align="middle" usemap="#estoremap" width="350" />
    </div>
</div>
</div>

<%--<div id="searchMsg">--%>
<%--<c:if test="${requestScope.searchMsg!=null }">--%>
<%--    <p><font color="white" >${requestScope.searchMsg}</font></p>--%>
<%--</c:if>--%>
<%--</div>--%>
<%--&lt;%&ndash;<c:if test="${sessionScope.searchMsg!=null}">&ndash;%&gt;--%>
<%--        <div id="searchMsg">--%>
<%--            <input type="button" style="display: block" onclick="tip()" id="tip" value="${sessionScope.searchMsg}" >--%>
<%--        </div>--%>
<%--</c:if>--%>



<%--<c:if test="${sessionScope.productList!=null&&sessionScope.keyword!=null}">--%>
<%--    <form action="productForm" method="post">--%>
<div id="searchlist">
    <%--            <c:forEach var="product" items="${sessionScope.productList}">--%>
    <ul id="productAutoList">
        <%--                    <li class="productAutoItem"><a href="productForm?name=${product.name}" >${product.name}</a></li>--%>
        <%--                    <input type="submit" style="display:block;" name="name" value="${product.name}">--%>
    </ul>
    <%--            </c:forEach>--%>
</div>

<%--</c:if>--%>






<%@ include file="../common/bottom.jsp"%>