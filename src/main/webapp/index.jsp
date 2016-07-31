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
		<jsp:include page="navbarLogin.htm" />
		<div id="loginModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
        			<div class="modal-header">
          				<button type="button" class="close" data-dismiss="modal">&times;</button>
          				<h4 class="modal-title">Login</h4>
        			</div>
        			<div class="modal-body">
          				<s:form action="login" class="form-horizontal" onsubmit="return checkLogin()" >
							<fieldset>
								<div class="form-group-lg">
									<label for="username">Username</label>
									<s:textfield name="username" class="form-control input-lg" requiredLabel="true" id="login-username" />
								</div>
							<br>
								<div class="form-group-lg">
									<label for="password">Password</label>
									<s:password name="password" class="form-control input-lg" requiredLabel="true" id="login-password" />
								</div>
							<br>	
								<input type="submit" class="btn btn-info btn-lg button" value="Login"/>
								
								<s:if test="#request.errorLogin!=null">
									<div class="text-danger" id="login-error">
										<s:property value="#request.errorLogin" />
									</div>
									<s:set scope="request" var="errorLogin" value=""></s:set>
								</s:if>
								
								<s:if test="#request.error!=null">
									<div class="text-danger" id="login-error">
										<s:property value="#request.error" />
									</div>
									<s:set scope="request" var="error" value=""></s:set>
								</s:if>
								
							</fieldset>
						</s:form>
        			</div>
        			<div class="modal-footer">
          				<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
        			</div>
      			</div>
			</div>
		</div>
		<div id="signupModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
        			<div class="modal-header">
          				<button type="button" class="close" data-dismiss="modal">&times;</button>
          				<h4 class="modal-title">Sign Up</h4>
        			</div>
        			<div class="modal-body">
						<s:form action="signup" class="form-horizontal" onsubmit="checkSignup()">
							<fieldset>
								<div class="form-group-lg">
									<label for="username">Username</label>
									<s:textfield name="user.username" class="form-control input-lg" id="signup-username" />
								</div>
							<br>
								<div class="form-group-lg">
									<label for="email">Email ID</label>
									<s:textfield name="user.email" class="form-control input-lg" id="signup-email" />
								</div>
							<br>
								<div class="form-group-lg">
									<label for="password">Password</label>
									<s:password name="user.password" class="form-control input-lg" id="signup-password" />
								</div>
							<br>
								 <input type="submit" class="btn btn-info btn-lg button" value="Sign Up" />
							</fieldset>
						</s:form>
						<s:if test="#request.errorSignup!=null">
							<div class="text-danger" id="signup-error">
								<s:property value="#request.errorSignup" />
							</div>
							<s:set scope="request" var="errorSignup" value=""></s:set>
						</s:if>
					</div>
					<div class="modal-footer">
          				<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
        			</div>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="page-header top-padding">
				<h1>Search for a cook! <small>Don't be hungry</small></h1>
			</div>
			
			<div class="">
			
			</div>
		</div>
		<jsp:include page="common/footer.html"></jsp:include>
	</body>
</html>