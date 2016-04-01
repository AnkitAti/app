<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Welcome <s:property value="#session.username"/></title>
		<jsp:include page="/common/res.html"></jsp:include>
	</head>
	<body>
		<jsp:include page="/common/header.jsp"></jsp:include>
		<br><br><br>
		<h1>Logged in</h1>
	</body>
</html>