<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Look A Cook | Signup | Login</title>
	<link href="style/style.css" rel="stylesheet" type="text/css">
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
					<s:form action="login" class="form-design" onsubmit="return checkLogin()">
						<s:textfield name="username"  placeholder="Username" id="login-username"/> 
						<s:password name="password" placeholder="Password" id="login-password"/>
						<input type="submit" class="btn" value="Login">
					</s:form>
					<s:if test="#request.error!=null">
						<div class="text-danger" id="login-error">
							<s:property value="#request.error" />
						</div>
						<s:set scope="request" var="error" value=""></s:set>
					</s:if>
				</div>
				<div class="register hide">
					<s:form action="signup" class="form-design" onsubmit="return checkSignup()">
						<s:textfield name="user.username" placeholder="Username" id="signup-username"/>
						<s:textfield name="user.email" placeholder="Email" id="signup-email"/> 
						<s:password name="user.password" placeholder="Password" id="signup-password"/> 
						<input type="submit" class="btn" value="Register">
					</s:form>
					<s:if test="#request.errorSignup!=null">
						<div class="text-danger" id="signup-error">
							<s:property value="#request.errorSignup" />
						</div>
						<s:set scope="request" var="errorSignup" value=""></s:set>
					</s:if>
				</div>
			</div>
		</div>
	</div>


	<%-- <jsp:include page="common/footer.html"></jsp:include> --%>
	<script src="scripts/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/app.js" type="text/javascript"></script>
</body>
</html>