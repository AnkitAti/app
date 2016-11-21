<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Look A Cook | Signup | Login</title>
	<link href="<c:url value="/resources/style/style.css"/>" rel="stylesheet" type="text/css">
	<!-- <style type="text/css">
	.left-pane,.list{text-align:center}body{font-family:"Lucida Grande","Lucida Sans Unicode","Lucida Sans","Open Sans Condensed",sans-serif;margin:0;height:1000px}.main-container{padding:0;width:100%;margin:0 auto}.left-pane{background-image:url(./resources/images/img.jpg);background-attachment:fixed;display:inline-block;width:70%;height:1000px}@media screen and (max-width:770px){.left-pane{width:0;display:none}}.right-pane{display:inline-block;width:29.6%;height:700px;position:fixed;overflow:hidden}@media screen and (max-width:770px){.right-pane{width:100%}}.list{display:block}.list hr{width:70%;border-top:1px solid #ff4500}.list .selected{border-bottom-color:#ff4500}.list .selected a{color:#111}.list .hide{display:none}.list ul{padding:0}.list ul li{border:2px solid transparent;margin:10px;padding:5px;display:inline-block;font-size:1.3em}.list ul li a{width:100px;text-decoration:none;color:#aaa}.list ul li a:hover{color:#111}.form-design{display:block}.form-design input[type=email],.form-design input[type=password],.form-design input[type=text]{font-size:1.3em;height:40px;width:80%;margin:20px;padding:4px 10px;border-radius:4px;-webkit-appearance:none;border:2px solid rgba(0,0,0,.5);transition:all .3s ease-in}.form-design input[type=email]:focus,.form-design input[type=password]:focus,.form-design input[type=text]:focus{outline:0;box-shadow:0 3px 3px 1px rgba(100,100,100,.8)}.form-design input[type=submit]{margin-top:20px;border-radius:6px;background:#fff;font-weight:200;font-size:1.2em;width:50%;height:45px;border:1px solid #000;transform:scale(1);transition:all .3s ease-in}.form-design input[type=submit]:focus,.form-design input[type=submit]:hover{color:#fff;background:#000;transform:scale(1.1);box-shadow:0 10px 20px rgba(10,10,10,.5)}.login{opacity:1}.register{opacity:0}
	</style> -->
</head>
<body>
	<div class="main-content">
		<div class="left-pane">
			<h1 class="app-name">Search Cooks</h1>
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
					<div class="error">
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/scripts/jquery.min.js"/>" type="text/javascript"></script>
	<!-- <script type="text/javascript">function checkLogin(){var e=$("#login-username").val(),a=$("#login-password").val();return null==e||""==e?($("#login-username").parent().addClass("has-error"),!1):null==a||""==a?($("#login-password").parent().addClass("has-error"),!1):!0}function checkSignup(){var e=$("#signup-username").val(),a=$("#signup-email").val(),s=$("#signup-password").val();return null==e||""==e?($("#signup-username").parent().addClass("has-error"),!1):null==a||""==a?($("#signup-email").parent().addClass("has-error"),!1):null==s||""==s?($("#signup-password").parent().addClass("has-error"),!1):!0}$(document).ready(function(){$("#login-id").click(function(){$(".links").each(function(){$(this).removeClass("selected")}),$(this).parent().addClass("selected"),$(".register").animate({opacity:0},1e3),$(".login").animate({opacity:1},1e3),$(".register").addClass("hide"),$(".login").removeClass("hide");return false;}),$("#register-id").click(function(){$(".links").each(function(){$(this).removeClass("selected")}),$(this).parent().addClass("selected"),$(".login").animate({opacity:0},1e3),$(".register").animate({opacity:1},1e3),$(".register").removeClass("hide"),$(".login").addClass("hide"); return false;})});</script> -->
	<script src="<c:url value="/resources/scripts/app.js"/>" type="text/javascript"></script>
</body>
</html>