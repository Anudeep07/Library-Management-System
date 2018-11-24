<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Library Management System</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/styles2.css">
</head>
<body>

	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		//this doesn't allow user to go back to login after he/she logs in
		if(session.getAttribute("username") != null) {
			response.sendRedirect("dashboard.jsp");
		}
	%>
	
	<div class="modal-dialog text-center">
		<div class="col-sm-8 main-section">
			<div class="modal-content">
				
				<form class="col-12" action="Login" method="post">
					<div class="form-group">
						
						<input type="text" class="form-control" name="username" placeholder="Enter Username" required>

					</div>
					<div class="form-group">
						
						<input type="password" class="form-control" name="password" placeholder="Enter Password" required>

					</div>

					<button type="submit" class="btn" id="login-button">Login</button>
					
					<c:if test="${error == 'error' }">
						<p id="errormessage">Invalid entry! Please try again.</p>
					</c:if>			
					

				</form>

			</div>
		</div>
	</div>


	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>