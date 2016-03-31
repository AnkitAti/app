<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>	
		<meta charset="UTF-8">
		<title>Logging out</title>
	</head>
	<body>
		<h1>Please wait..we are logging you out....</h1>
		<%
			session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("../index.htm");
		%>
	</body>
</html>