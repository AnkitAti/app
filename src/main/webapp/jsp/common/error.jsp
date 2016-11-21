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
.info span:hover{
	color:deepskyblue;
	font-weight: bold;
}
.image {
	display: inline-block;
}
.face {
	margin: 50px 0;
	border: 5px solid black;
	height: 200px;
	width: 200px;
	border-radius: 50%;
	position: relative;
}
.eye {
	position: absolute;
	display: inline-block;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	background-color: black;
}
.face .eye:nth-child(1) {
	left: 28px;
	top: 50px;
}
.face .eye:nth-child(3) {
	left: 138px;
	top: 50px;
}
.mouth {
	position: absolute;
	top: 100px;
	left: 50px;
	margin-top: 40px;	
	display: inline-block;
	width: 80px;
	height: 80px;
	border-radius: 50%;
	border:8px solid transparent;
	border-top-color: black;
}
</style>
</head>
<body>
	<div class="content">
		<h1>Oops....Something went wrong!!</h1>
		<div class="info"> The URL you are looking for seems to be broken or does not exist. If you think something's wrong with us, please feel free to write
		us at <span class="email">lookacook@gmail.com</span>. We'll make sure to fix the issue and reply to you as soon as possible.
		</div>
		
		<div class="image">
			<div class="face">
				<div class="eye"></div>
				<div class="mouth"></div>
				<div class="eye"></div>
			</div>
			<div class="msg">
				<h1>404</h1>
			</div>
		</div>
	</div>
	
</body>
</html>