<%@ page contentType= "text/html; charset=GBK"  language= "java"  import = "java.sql.*"  errorPage= ""  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<form action="register" method="POST">
    <c:if test="${requestScope.registerMsg !=null }">
        <div class="login-form-error">
            <p class="error-msg"><font color="red">${requestScope.registerMsg}</font></p>
        </div>
    </c:if>
    <table border="1">
        <h2 align="center">USER INFORMATION</h2>
        <tbody>

        <tr>
            <td>USER ID:</td>
            <td >
                <input type="text" name="username" id="Name">
            </td>
        </tr>
        <tr>
            <td>NEW PASSWORD:</td>
            <td >
                <input type="text" name="password">
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
    <table border="1">
        <h2 align="center">ACCOUNT INFORMATION</h2>
        <tbody>

        <tr>
            <td>FIRST NAME:</td>
            <td>
                <input type="text" name="firstName">
            </td>
        </tr>
        <tr>
            <td>LAST NAME:</td>
            <td >
                <input type="text" name="lastName">
            </td>
        </tr>
        <tr>
            <td>EMAIL:</td>
            <td >
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>PHONE:</td>
            <td >
                <input type="text" name="phone">
            </td>
        </tr>
        <tr>
            <td>ADDRESS 1:</td>
            <td >
                <input type="text" name="address1">
            </td>
        </tr>
        <tr>
            <td>ADDRESS 2:</td>
            <td >
                <input type="text" name="address2">
            </td>
        </tr>
        <tr>
            <td>CITY:</td>
            <td >
                <input type="text" name="city">
            </td>
        </tr>
        <tr>
            <td>STATE:</td>
            <td >
                <input type="text" name="state">
            </td>
        </tr>
        <tr>
            <td>ZIP:</td>
            <td >
                <input type="text" name="zip">
            </td>
        </tr>
        <tr>
            <td>COUNTRY:</td>
            <td >
                <input type="text" name="country">
            </td>
        </tr>
        </tbody>
    </table>
    <div >
        <tr>
            <td colspan="2" ><input name="submit" type="submit" id="btn_sub" onclick="disp_alert()" value="Register"></td>
            <td colspan="2" ><input name="back"  value="·µ»ØµÇÂ¼½çÃæ" id="btn_reset" onclick="window.location.href='signonForm'"></td>
        </tr>
    </div>
</form>
</body>
</html>
