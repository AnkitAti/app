<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Welcome </title>
		<jsp:include page="../common/styles.jsp" />
	</head>
	<body>
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		<div class="content">
			<div class="info col-lg-5 col-md-5 col-sm-12 col-xs-12">
				<h3>Welcome to look a cook</h3>
				<p> Looking for cooks? Looking for someone to share your load with?</p>
				<p> Don't worry we are here. Just search the most appropriate cook and we will manage the rest of stuffs.</p>
			</div>
			<div class="box col-lg-6 col-md-6 col-sm-12 col-xs-12 center-horizontal">
				<h1>Search</h1>
				<form>
					<div class="input-field col-lg-6 col-md-6 col-sm-6 col-xs-12">
	          			<input id="state" type="text" class="validate">
	          			<label for="state">Enter State</label>
	        		</div>
	        		<div class="input-field col-lg-6 col-md-6 col-sm-6 col-xs-12">
	          			<input id="city" type="text" class="validate">
	          			<label for="city">Enter City</label>
	        		</div>
					<button type="submit" id="search" class="waves-effect waves-light btn">Search Cook</button>
				</form>
			</div>
			
		</div>
		
		<jsp:include page="../common/footer.jsp" />
		<jsp:include page="../common/scripts.jsp" />
	</body>
</html>