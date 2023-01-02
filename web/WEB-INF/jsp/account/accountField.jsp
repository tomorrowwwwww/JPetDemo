
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<div class="table-1">
<table>
    <tr>
        <td>First name:</td>
        <td><input type="text" name="firstName" value="${sessionScope.loginAccount.firstName}"/></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" value="${sessionScope.loginAccount.lastName}"/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" size="40" name="email" value="${sessionScope.loginAccount.email}" /></td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" value="${sessionScope.loginAccount.phone}" /></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" size="40" name="address1" value="${sessionScope.loginAccount.address1}" /></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" size="40" name="address2" value="${sessionScope.loginAccount.address2}" /></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" value="${sessionScope.loginAccount.city}" /></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" size="4" name="state" value="${sessionScope.loginAccount.state}" /></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" size="10" name="zip" value="${sessionScope.loginAccount.zip}" /></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td><input type="text" size="15" name="country" value="${sessionScope.loginAccount.country}" /></td>
    </tr>
</table>

<table>
    <tr>
        <td>Language Preference:</td>
        <td>
            <select name="languagePreference">
                <option value="english" selected="selected">english</option>
                <option value="japanese">japanese</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <select name="favouriteCategoryId">
                <option value="FISH">FISH</option>
                <option selected="selected" value="DOGS">DOGS</option>
                <option value="REPTILES">REPTILES</option>
                <option value="REPTILES">REPTILES</option>
                <option value="CATS">CATS</option>
                <option value="BIRDS">BIRDS</option>
            </select>
        </td>
    </tr>
    <input type="submit" name="saveAccount" value="Save Account Information" />

</table>
</div>
</body>