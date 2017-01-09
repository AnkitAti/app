<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login</title>
		<link href="<c:url value="/resources/style/style.css"/>" rel="stylesheet" type="text/css">
	</head>
	<body>
		<h1 style="text-align: center">Look a Cook</h1>
		<div class="box">
			<h2>Login</h2>
			<form class="form-design" action="login" method="post" onsubmit="return checkLogin()">
	        	<input id="login-username" type="text" name="username" placeholder="Username or Email" value="<c:out value="${usernameLogin}"/>">
	        	<input id="login-password" type="password" name="password" placeholder="Password">
			    <c:if test="${not empty param.redirect}">
					<input type="hidden" name="redirect" value="<c:out value="${param.redirect}" />" >
				</c:if>
				<input type="hidden" name="from" value="login">
				<input type="submit" class="btn" value="Login">
			</form>
			<c:if test="${not empty errorLogin}">
				<div class="error">
					<h3>${errorLogin}</h3>
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.error}">
				<div class="error">
					<h3>${sessionScope.error}</h3>
				</div>
				<c:remove var="error" scope="session" />
			</c:if>
			<div id="error-msg">
			</div>
			<div class="info">
				<em>Don't have account? <a href="signup">Signup. It's free!</a></em>
			</div>
		</div>
		<script src="<c:url value="/resources/scripts/jquery.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/resources/scripts/app.js"/>" type="text/javascript"></script>
	</body>
</html>