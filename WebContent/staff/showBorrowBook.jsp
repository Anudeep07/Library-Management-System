<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<h3>Student Details</h3>
	<table class="table table-hover">
	  <thead>
	    <tr>	    
	      <th scope="col">Username</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Semester</th>
	      <th scope="col">Department</th>
	      <th scope="col">Books Borrowed</th>
	    </tr>
	  </thead>
	  <tbody>
  
	  	<tr>
	      <th scope="row">${student.studentid } </th>
	      <td>${student.firstname }</td>
	      <td>${student.lastname }</td>
	      <td>${student.semester }</td>
	      <td>${student.department }</td>
	      <td>${student.booksborrowed }</td>	   
	    </tr>	
  
	  </tbody>
	</table>
	
	<h3>Book Details</h3>
	<table class="table table-hover">
		<thead>
		    <tr>	    
		      <th scope="col">ISBN</th>
		      <th scope="col">Title</th>
		      <th scope="col">Author</th>
		      <th scope="col">Quantity</th>	      
		    </tr>
	 	</thead>
		<tbody>

		  	<tr>
		      <th scope="row">${book.isbn } </th>
		      <td>${book.title }</td>
		      <td>${book.author }</td>
		      <td>${book.quantity }</td>
		    </tr>	
		  
		</tbody>
	</table>	
	
	<form method="get" action="ReturnBook">
  
	  <div class="form-row">
		  <div class="form-group col-md-6">
		      <label for="startdate">Issue Date</label>
		      <input type="date" id="startdate" class="form-control" name="issuedate" value="${issuedate }" readonly>
		    </div>
		  <div class="form-group col-md-6">
		    <label for="returndate">Return Date</label>
		    <input type="date" id="returndate" class="form-control" name="returndate" value="${returndate }" readonly>
		  </div>
	  </div>
	  
		<button type="submit" class="btn btn-primary submitButton">Go Back</button>
	</form>
</div>