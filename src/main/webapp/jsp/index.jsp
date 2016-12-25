<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Look A Cook | Signup | Login</title>
	<link href="<c:url value="/resources/style/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main-content">
		<div class="left-pane">
			<div class="parallex first"></div>			
			<div class="main-panel">
				<h1 class="app-name">Search Cooks</h1>	
				<h4>No Cook! No Food!</h4>
				<p>We understand that food is one of the most basic need of human. And it is not easy to 
				work and cook as well. So give us a chance to help you.
				Login and book a cook now and get rid of the disturbing thoughts.</p>
			</div>
			<div class="parallex second"></div>
		</div>
		<div class="right-pane">
			<div class="list">
				<h2>Look a Cook</h2>
				<hr>
				<ul>
					<li class="links selected"><a href="#" id="login-id">Login</a></li>
					<li class="links"><a href="#" id="register-id">Register</a></li>
				</ul>
				<div class="login">
					<form action="login" class="form-design" method="post" onsubmit="return checkLogin()">
						<input type="text" name="username" placeholder="Username or Email" id="login-username" value="<c:out value="${usernameLogin}"/>" /> 
						<input type="password" name="password" placeholder="Password" id="login-password"/>
						<c:if test="${not empty param.redirect}">
							<input type="hidden" name="redirect" value="<c:out value="${param.redirect}" />" >
						</c:if>
						<input type="hidden" name="from" value="index">
						<input type="submit" class="btn" value="Login">
					</form>
					<div class="error">
						<c:if test="${not empty errorLogin}">
							<h3><c:out value="${errorLogin}" /></h3>
						</c:if>
					</div>
				</div>
				<div class="register hide">
					<form action="signup" class="form-design" method="post" onsubmit="return checkSignup()">
						<input type="text" name="username" placeholder="Username" id="signup-username" value="<c:out value="${usernameSignup}"/>" />
						<input type="email" name="email" placeholder="Email" id="signup-email" value="<c:out value="${emailSignup}"/>" /> 
						<input type="password" name="password" placeholder="Password" id="signup-password"/> 
						<input type="submit" class="btn" value="Register">
					</form>
					<div class="error">
						<c:if test="${not empty errorSignup}">
							<h3><c:out value="${errorSignup}" /></h3>
							<div id="show-signup"></div>
						</c:if>
					</div>
				</div>
				<div class="error">
					<c:if test="${not empty error}">
						<h3><c:out value="${error}"/></h3>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/scripts/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/scripts/app.js"/>" type="text/javascript"></script>
</body>
</html>