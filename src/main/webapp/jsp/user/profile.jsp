<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Profile</title>
		<jsp:include page="../common/styles.jsp" />
	</head>
	<body>
		<jsp:include page="../common/header.jsp" />
		
		<div class="content">
			<div class="box">
				<div class="left-pane">
					<div class="image"></div>
					<a href="edit_profile" class="waves-effect waves-light btn">Edit Profile</a>
				</div>
				<div class="middle-pane">
					<div class="info">
						<p> Username: <c:out value="${userDesc.user.username }" /></p>
						<p> Email: <c:out value="${userDesc.user.email}"/> </p>
						<p> Name: <c:out value="${userDesc.firstName }" /> <c:out value="${userDesc.lastName}" /></p>
						<p> Gender: <c:out value="${userDesc.gender}" /> </p>
						<p> Phone: <c:out value="${userDesc.phone }" /></p>
					</div>
				</div>
				<div class="right-pane">
					<h3>Your Activities</h3>
				</div>
			</div>
		</div>
		
		<jsp:include page="../common/footer.jsp" />
		<jsp:include page="../common/scripts.jsp" />
	</body>
</html>