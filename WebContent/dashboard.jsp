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
		
		<c:import url="admin/Navbar.jsp"></c:import>
		
		<c:if test="${status == 'addstaff' }">
			<c:import url="admin/addStaff.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'addadmin' }">
			<c:import url="admin/addAdmin.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'removeadmin' }">
			<c:import url="admin/removeAdmin.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'editstaff' }">
			<c:import url="admin/editStaff.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'modifystaff' }">
			<c:import url="admin/modifyStaff.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'addstudent' }">
			<c:import url="admin/addStudent.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'editstudent' }">
			<c:import url="admin/editStudent.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'modifystudent' }">
			<c:import url="admin/modifyStudent.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'changepassword' }">
			<c:import url="changePassword.jsp"></c:import>
		</c:if>
				
		<c:if test="${status == null }">
			<c:import url="admin/admindashboard.jsp"></c:import>
		</c:if>
		
	</c:if>
	
	<c:if test="${role == 'LIBRARIAN' }">
		<c:import url="staff/Navbar.jsp"></c:import>
		
		<c:if test="${status == 'addbook' }">
			<c:import url="staff/addBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'modifybook' }">
			<c:import url="staff/modifyBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'editbook' }">
			<c:import url="staff/editBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'issuebook' }">
			<c:import url="staff/issueBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'returnbook' }">
			<c:import url="staff/returnBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'showborrowbook' }">
			<c:import url="staff/showBorrowBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'changepassword' }">
			<c:import url="changePassword.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == null }">
			<c:import url="staff/staffdashboard.jsp"></c:import>
		</c:if>
		
		
	</c:if>	
	
	<c:if test="${role == 'STUDENT' }">
		<c:import url="student/Navbar.jsp"></c:import>
		
		<c:if test="${status == 'changepassword' }">
			<c:import url="changePassword.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == 'searchbook' }">
			<c:import url="student/searchBook.jsp"></c:import>
		</c:if>
		
		<c:if test="${status == null }">
			<c:import url="student/studentdashboard.jsp"></c:import>
		</c:if>
	</c:if>
	
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>