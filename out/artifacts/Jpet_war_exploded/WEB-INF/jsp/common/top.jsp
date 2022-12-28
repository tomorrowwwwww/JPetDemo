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
</head>
<body>
<div class="header_con">
    <!-- h1里面放logo哦 -->
    <h1>
        <img src="images/logo2.jpg" alt="">
    </h1>

    <!-- 头部右侧表单标签-->
    <form action="searchproduct" method="post" id="nav_search">
        <input type="text" class="search" name="keyword">
        <div>
            <button type="submit" class="btn" id="searchBtn" >
            </button>
        </div>
    </form>
</div>

<!-- 导航栏平铺部分：会显示黑色啦 -->

<div id="nav">
    <!-- 导航栏版心部分 -->
    <div class="nav_con">
        <ul id="lilist">
            <li class="margin-left"><a href="cartForm"><img align="center" src="images/cart.jpg" /></a>
                <c:if test="${sessionScope.loginAccount ==null }">
            <li id="li1">  <a href="signonForm">Sign In</a></li>
            </c:if>
            <c:if test="${sessionScope.loginAccount !=null }">
                <li id="li2" ><a href="signoutForm">Sign Out</a></li>
                <li id="li3"> <a href="editAccount">My Account</a></li>
                <li id="li4"> <a href="myOrdersForm">My Orders</a></li>
            </c:if>

        </ul>
        <li><a href="help.html">?</a> </li>
    </div>
</div>
