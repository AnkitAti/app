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
			<h1>Look a Cook</h1>
			<form>
				<div class="input-field col-lg-6 col-md-6 col-sm-6 col-xs-12">
          			<input id="place" type="text" class="validate">
          			<label for="place">Enter City</label>
        		</div>
				<button type="submit" id="search" class="waves-effect waves-light btn-large">Search Cook</button>
			</form>
		</div>
		
		<jsp:include page="../common/footer.jsp" />
		<jsp:include page="../common/scripts.jsp" />
	</body>
</html>