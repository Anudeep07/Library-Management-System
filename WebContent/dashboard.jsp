<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">			<!-- bootstrap css -->
	<link rel="stylesheet" type="text/css" href="css/stylesdashboard.css">		<!-- dashboard style --> 
	<link rel="stylesheet" type="text/css" href="css/fontawesome/css/all.css">	<!-- fontawesome icons -->
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		//this doesn't allow user to go back to welcome after he/she logs out
		if(session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
		
	<c:if test="${role == 'ADMIN' }">
		<c:import url="admin/admindashboard.jsp"></c:import>
	</c:if>
	
	<c:if test="${role == 'LIBRARIAN' }">
		<c:import url="librarian/librariandashboard.jsp"></c:import>
	</c:if>	
	
	<c:if test="${role == 'STUDENT' }">
		<c:import url="student/studentdashboard.jsp"></c:import>
	</c:if>
	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>