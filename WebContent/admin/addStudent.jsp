<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">
	<div class="page-header text-center">
		<h2>Add Student</h1>
	</div>
	
	<hr>
	<form method="post" action="AddStudent">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="firstname">First Name</label>
	      <input type="text" class="form-control" id="firstname" name="fname"  placeholder="First Name" required>
	    </div>
	  
	    <div class="form-group col-md-6">
	      <label for="lastname">Last Name</label>
	      <input type="text" class="form-control" id="lastname" name="lname" placeholder="Last Name" required>
	    </div>
	    
	   </div> 
	   <div class="form-group">
	    <label for="userid">Student ID</label>
	    <input type="text" class="form-control" id="userid" name="studentid" placeholder="Student ID" required>
	  </div>
	  
	  <div class="form-row">
	  	<div class="form-group col-md-6">
	      	<label for="inputState">Department</label>
	      	<select id="inputState" class="form-control" name="Department">
	        <option selected value=0>Choose...</option>
	        <option value="Computer Science">Computer Science</option>
	        <option value="Electronics">Electronics</option>
	        <option value="Mechanical">Mechanical</option>
	        <option value="Information Science">Information Science</option>
	        <option value="Biotechnology">Biotechnology</option>
	      </select>
	  	</div>
	  
	 
	    <div class="form-group col-md-6">
	      <label for="Semester">Semester</label>
	      <input type="number" min="1" max="8" class="form-control" id="" name="Semester" placeholder="Enter Semester" required>
	    </div>
	    
	  </div>
	  <button type="submit" class="btn btn-primary submitButton">Submit</button>
	</form>
	<c:if test="${addstatus == 'success' }">
		<p>Successfully added.</p>
	</c:if>
	<c:if test="${addstatus == 'duplicateuser' }">
		<p>Duplicate user.</p>
	</c:if>
	<c:if test="${addstatus == 'statefail' }">
		<p>Please select a department.</p>
	</c:if>
</div>