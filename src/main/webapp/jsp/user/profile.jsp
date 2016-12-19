<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Profile</title>
		<jsp:include page="../common/styles.jsp" />
	</head>
	<body>
		<jsp:include page="../common/header.jsp" />
		
		<div class="content">
			<div class="image">
			</div>
			<div class="info">
				<p> Username: <c:out value="${userDesc.user.username }" /></p>
				<p> Name: <c:out value="${userDesc.firstName }" /> <c:out value="${userDesc.lastName}" /></p>
				
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp" />
		<jsp:include page="../common/scripts.jsp" />
	</body>
</html>