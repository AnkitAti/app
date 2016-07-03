<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initialscale=1.0">
		<title>Welcome <s:property value="#session.username"/></title>
		<jsp:include page="/common/res.html"></jsp:include>
	</head>
	<body>
		<jsp:include page="/common/header.jsp"></jsp:include>
		<br><br><br>
		<div class="container">
			<div class="search-form col-md-offset-2 col-md-8">
			<s:if test="#request.city">
				<s:if test="#request.type">
					<s:form action="search" class="form-horizontal">
						<s:select list="#request.city"></s:select>
						<s:select list="#request.type"></s:select>
					</s:form>
				</s:if>
			</s:if>
			<s:else>
				<h2>We are extremenly sorry, Search form is not available.</h2>
				<h2 style="text-align:center"> Please come back after some time, while we are fixing it.</h2>
			</s:else>
			</div>
		</div>
	</body>
</html>