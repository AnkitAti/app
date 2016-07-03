<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Look A Cook | Signup | Login</title>
		<jsp:include page="common/res.html" />
	</head>
	<body>
		<br>
		<div class="container">
		<div class="col-md-offset-7">
			<s:form action="login" class="form-inline">
				<fieldset>
					<div class="form-group">
						<s:textfield name="username" class="form-control input-sm" requiredLabel="true"  id="" />
					</div>
					<div class="form-group">
						<s:password name="password" class="form-control input-sm" requiredLabel="true" id="" />
					</div>
					<input type="submit" class="btn btn-default button" onclick="" value="Login"/>
				</fieldset>
			</s:form>
			</div>
			<div class="col-md-offset-7">
				<s:if test="#request.errorLogin!=null">
					<span style="color:red;"><s:property value="#request.errorLogin" /></span>
					<s:set scope="request" var="errorLogin" value=""></s:set>
				</s:if>
			</div>
	</div>
	<br>
	<br>
	<div class="row">
		<div class="col-md-offset-1 col-md-6">
			<img src="res/cook1.jpg" alt="Look A Cook" width="" height="" class="img-responsive" />
		</div>
		<div class="col-md-1">
		</div>
		<div class="col-md-3">
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
						<s:textfield name="user.email" class="form-control input-lg" id="" />
					</div>
					<br>
					<div class="form-group-lg">
						<label for="password">Password</label>
						<s:password name="user.password" class="form-control input-lg" id="" />
					</div>
					<br> <input type="submit" class="btn btn-lg button" onclick=""
						value="Sign Up" />
				</fieldset>
			</s:form>
				
			<s:if test="#request.errorSignup!=null">
				<span style="color:red"><s:property value="#request.errorSignup" /></span>
				<s:set scope="request" var="errorSignup" value=""></s:set>
			</s:if>
		</div>
	</div>
	<footer class="footer">
		
	</footer>
</body>
</html>