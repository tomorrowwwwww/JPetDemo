<%@ page contentType= "text/html;charset=UTF-8"  language= "java"  import = "java.sql.*"  errorPage= ""  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Register</title>
  <link rel="stylesheet" type="text/css" href="css/account.css">
</head>
<body>
<%@ include file="../common/top.jsp"%>
<div id="BackLink">
  <a href="mainForm">Return to Main Menu</a>
</div>

<div id="Catalog">
  <form action="saveAccount" method="POST">
    <c:if test="${requestScope.registerMsg !=null }">
      <div class="login-form-error">
        <p class="error-msg"><font color="red">${requestScope.registerMsg}</font></p >
      </div>
    </c:if>
    <table border="1">
      <h2 align="center">USER INFORMATION</h2>
      <tbody>

      <tr>
        <td>USER ID:</td>
        <td>${sessionScope.account.username}</td>
      </tr>
      <tr>
        <td>NEW PASSWORD:</td>
        <td >
          <input type="text" name="password" autofocus="autofocus">
        </td>
      </tr>
      <tr>
        <td>REPEAT PASSWORD:</td>
        <td >
          <input type="text" name="repeatPassword">
        </td>
      </tr>
      </tbody>
    </table>
    <h2 align="center">ACCOUNT INFORMATION</h2>
    <%@ include file="accountField.jsp"%>
  </form>
</div>
</body>
<%@ include file="../common/bottom.jsp"%>
</html>