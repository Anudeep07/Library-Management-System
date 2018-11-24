<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<h2 class="text-center">Select the Student</h2>

	<form method="post" action="IssueBookAddStudent">

	  <input type="text" name="isbn" value="${bookisbn }" hidden>
	<div class="input-group mb-3">
	  <input type="text" class="form-control" id="search-textbox" name="searchbox" placeholder="Search" aria-label="Search" aria-describedby="basic-addon2">
	  <div class="input-group-append">
	    <button class="btn btn-outline-secondary" type="submit"><i class="fas fa-search"></i>Search</button>
	  </div>
	</div>
	</form>
	
	<table class="table table-hover">
	  <thead>
	    <tr>	    
	      <th scope="col">Username</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Semester</th>
	      <th scope="col">Department</th>
	      <th scope="col">Books Borrowed</th>
	      <th scope="col">Select</th>	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="student" items="${studentList }">
	
		  	<tr>
		      <th scope="row">${student.studentid } </th>
		      <td>${student.firstname }</td>
		      <td>${student.lastname }</td>
		      <td>${student.semester }</td>
		      <td>${student.department }</td>
		      <td>${student.booksborrowed }</td>
		      <td><button onclick="location.href='IssueComplete?user=${student.studentid}&isbn=${bookisbn }'" type="button" class="btn btn-secondary">Select</button></td>
		    </tr>	
	  	
	  	</c:forEach>
	  
	  </tbody>
	</table>
</div>