<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType= "text/html; charset=GBK"  language= "java"  import = "java.sql.*"  errorPage= ""  %>
<html lang="en">
<head>
    <title>JPetStore</title>
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="imagetoolbar" content="no">
</head>
<body>
<div id="Catalog" class="box">
    <form action="signOn" method="post">
        <div class="login">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form">
				<span class="login100-form-title" ><font color="#f0f8ff"></font>
					Login
				</span>
                        <span class="login100-form-title" ><font color="#ff6851" size:10px></font>
					<c:if test="${requestScope.signOnMsg !=null }">
                        <font color="#f0f8ff" >${requestScope.signOnMsg}</font>
                    </c:if>
				</span>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" name="username" placeholder="Account"
                                   id="usernamelogin">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</span>
                        </div>
                        <span id="usernameloginTips" align="center"></span>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="password" name="password" placeholder="Password" id="newpw">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
							</span>
                        </div>

                        <div class="vcodediv">
                            <span>VerificationCode:</span>
                            <input type="text" name="vCode" size="5" maxlength="4" class="vcode"/>
                            <a href="signOn"><img border="0" src="verificationCode" name="checkcode"></a>
                        </div>

                        <div class="container-login100-form-btn">
                            <input type="submit" name="signon" value="Login" class="login100-form-btn">
                        </div>
                        <span class="login100-form-title" >
                             <a href="registerForm">Register Now!</a>
				        </span>
                    </form>
                </div>
            </div>
        </div>
    </form>
    <%--    <div class="toCenter">--%>
    <%--        <p><font color="black">Need a user name and password?</font></p>--%>
    <%--    </div>--%>
    <%--    <div class="toCenter1">--%>
    <%--        <a href="registerForm">Register Now!</a>--%>
    <%--    </div>--%>
</div>
</body>
