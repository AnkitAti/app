<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Look A Cook | Signup | Login</title>
	<link href="<c:url value="/resources/style/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main-content">
		<div class="left-pane">
			<h1>Search Cooks</h1>
			<div class="main-panel">
			</div>
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
						<input type="text" name="username"  placeholder="Username" id="login-username"/> 
						<input type="password" name="password" placeholder="Password" id="login-password"/>
						<input type="submit" class="btn" value="Login">
					</form>
				</div>
				<div class="register hide">
					<form action="signup" class="form-design" method="post" onsubmit="return checkSignup()">
						<input type="text" name="username" placeholder="Username" id="signup-username"/>
						<input type="email" name="email" placeholder="Email" id="signup-email"/> 
						<input type="password" name="password" placeholder="Password" id="signup-password"/> 
						<input type="submit" class="btn" value="Register">
					</form>
				</div>
			</div>
		</div>
	</div>


	<%-- <jsp:include page="common/footer.html"></jsp:include> --%>
	<script src="<c:url value="/resources/scripts/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/scripts/app.js"/>" type="text/javascript"></script>
</body>
</html>