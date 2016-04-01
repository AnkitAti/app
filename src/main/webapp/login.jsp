<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Look A Cook | Signup | Login</title>

		<script type="text/javascript" src="scripts/jquery.min.js" async></script>
		<script type="text/javascript" src="scripts/angular.min.js" async></script>
		<script type="text/javascript" src="scripts/bootstrap.min.js" async></script>
		
		<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css">
	</head>
	<body>
		<br>
		<div class="col-md-offset-6">
			<s:form action="login" class="form-inline">
				<fieldset>
					<div class="form-group">
						<label for="username">Username or Email ID</label>
						<s:textfield name="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<s:password name="password" class="form-control" />
					</div>
					<input type="submit" class="btn btn-default" onclick="" value="Login" />
				</fieldset>
			</s:form>
			<div class="col-md-offset-2 col-md-7 alert alert-danger">
				<s:if test="#request.error!=null">
					<s:property value="#request.error" />
					<s:set scope="request" var="error" value="null"></s:set>
				</s:if>
			</div>
		</div>
		<br>
		<br>
		<div class="col-md-offset-8 col-md-3">
			<s:form action="signup" class="form-horizontal">
				<fieldset>
				<legend>Sign Up</legend>
				<div class="form-group-lg">
					<label for="username">Username</label>
					<s:textfield name="user.username" class="form-control input-lg" />
				</div>
				<br>
				<div class="form-group-lg">
					<label for="email">Email ID</label>
					<s:textfield name="user.email" class="form-control input-lg" />
				</div>
				<br>
				<div class="form-group-lg">
					<label for="password">Password</label>
					<s:password name="user.password" class="form-control input-lg" />
				</div>
				<br>
				<input type="submit" class="btn btn-lg" onclick="" value="Sign Up" />
				</fieldset>
			</s:form>
		</div>
	</body>
</html>