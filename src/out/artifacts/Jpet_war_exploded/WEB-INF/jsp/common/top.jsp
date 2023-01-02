<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>JPetStore</title>
    <link rel="stylesheet" href="css/mainpage.css" type="text/css">
    <style type="text/css">
        body{
            background: url(images/mainpage.jpg);
            background-size: cover;
            background-attachment: fixed;
        }
    </style>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<div class="header_con">
    <!--logo-->
    <h1>
        <img src="images/logo2.jpg" alt="">
    </h1>

    <!-- 头部右侧表单标签-->

    <form action="searchproduct" method="post" id="nav_search">
        <input type="text" class="search" name="keyword" id="keyword">
        <div>
            <button type="submit" class="btn" id="searchBtn" >
            </button>
        </div>
    </form>
</div>
</div>

<!-- 导航栏部分 -->

<div id="nav">
    <!-- 导航栏版心部分 -->
    <div class="nav_con">
        <ul id="lilist">
            <li class="margin-left"><a href="cartForm"><img align="center" src="images/cart.jpg" /></a>
                <c:if test="${sessionScope.loginAccount ==null }">
                    <%--                    <li>  <a href="signonForm">Sign In</a></li>--%>
                <div id="account1" class="img">
                    <a href="signonForm"> <img src="images/default_signin.jpg"></a>
                </div>
                </c:if>
                <c:if test="${sessionScope.loginAccount !=null }">
            <li><a href="signoutForm">Sign Out</a></li>
            <li><a href="myOrdersForm">My Orders</a></li>
                <%--                        <li id="li3"> <a href="editAccount">My Account</a></li>--%>
            <div id="account2" class="img">
                <a href="editAccount"><img src="images/default_signout.jpg"></a>
                <p>欢迎用户${sessionScope.loginAccount}登录!</p>
            </div>
            </c:if>
            <li><a href="help">?</a> </li>
        </ul>

    </div>
</div>
</body>


<script>
    function Search() {
        //获取关键字
        var keyword=document.getElementById(keyword);
        //传到后端
        console.log(keyword+12345);
        xmlhttp=new XMLHttpRequest();
        if(xmlhttp){
            xmlhttp.open("post","top.jsp",true);
            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState===4){
                    if((xmlhttp.status>=200&&xmlhttp.status<=300)||xmlhttp.status==304){
                        var productlist=xmlhttp.responseText;
                        console.log(productlist);
                    }
                }

            }
            xmlhttp.send(keyword);
        }


    }
</script>
