<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Look A Cook</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Bungee+Inline|Delius+Unicase|Nunito|Ravi+Prakash');
h1 {
	font-family: 'Bungee Inline', cursive;
}
h1:not(.msg) {
	color: deepskyblue;
}
body {
	font-family: 'Nunito', sans-serif;
}
.content {
	margin: 20px;
	text-align: center;
}
.image {
	display: inline-block;
}
.face {
	margin: 50px 0;
	border: 8px solid black;
	height: 100px;
	width: 100px;
	border-radius: 50%;
	position: relative;
}
.eye {
	position: absolute;
	display: inline-block;
	width: 15px;
	height: 15px;
	border-radius: 50%;
	background-color: black;
}
.face .eye:nth-child(1) {
	left: 18px;
	top: 25px;
}
.face .eye:nth-child(3) {
	left: 68px;
	top: 25px;
}
.mouth {
	position: absolute;
	top: 65px;
	left: 18px;
	display: inline-block;
	width: 50px;
	height: 50px;
	border-radius: 50%;
	border:8px solid transparent;
	border-top-color: black;
}
</style>
</head>
<body>
	<div class="content">
		<h1>Oops....Something went wrong!!</h1>
		<div class="image">
			<div class="face">
				<div class="eye"></div>
				<div class="mouth"></div>
				<div class="eye"></div>
			</div>
			<div class="msg">
				<h1>404</h1>
				<h4>Page Not Found</h4>
			</div>
		</div>
	</div>
	
</body>
</html>