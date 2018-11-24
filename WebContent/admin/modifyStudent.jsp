<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%	
	response.sendRedirect("../dashboard.jsp");		
%>



<div class="container topmarginlib">
	
	<div class="page-header text-center">
		<h2>Modify Student</h1>
	</div>
	
	<hr>
	
	
  <c:if test="${modifystatus != null }">
  	<button onclick="location.href='dashboard.jsp'" class="btn btn-primary submitButton">Return to dashboard</button>
  </c:if>
  <c:if test="${modifystatus == null }">
	<form method="post" action="ModifyStudent">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="firstname">First Name</label>
	      <input type="text" class="form-control" id="firstname" name="fname" value="${student.firstname }"  placeholder="First Name" required>
	    </div>
	  
	    <div class="form-group col-md-6">
	      <label for="lastname">Last Name</label>
	      <input type="text" class="form-control" id="lastname" name="lname" value="${student.lastname }" placeholder="Last Name" required>
	    </div>
	    
	   </div> 
	  <div class="form-group">
	    <label for="userid">Student ID</label>
	    <input type="text" class="form-control" id="userid" name="studentid" value="" placeholder="Student ID" required readonly>
	  </div>
	  
	<div class="form-row">
	  <div class="form-group col-md-6">
	     <label for="Semester">Semester</label>
	     <input type="number" min="1" max="8" class="form-control" id="" name="Semester" value="${student.semester }" placeholder="Enter Semester" required>
	  </div>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputDepartment">Department</label>
	      <input type="text" class="form-control" id="inputDepartment" name="Department" value="${student.department }" placeholder="Department" required>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="inputState">Department</label>
	      <select id="inputState" class="form-control" name="Department">
	        <option value=0>Choose...</option>
	        
	        <c:choose>
			    <c:when test="${student.department == 'Computer Science'}">
			        <option selected value='Computer Science'>Computer Science</option>			      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value='Computer Science'>Computer Science</option>
			    </c:otherwise>
			</c:choose>
			
			<c:choose>
			    <c:when test="${student.department == 'Electronics'}">
			        <option selected value="Electronics">Electronics</option>	      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value="Electronics">Electronics</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${student.department == 'Mechanical'}">
			        <option selected value=Mechanical>Mechanical</option>		      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value=Mechanical>Mechanical</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${student.department == 'Information Science'}">
			        <option selected value='Information Science'>Information Science</option>			      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value='Information Science'>Information Science</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${student.department == 'Biotechnology'}">
			        <option selected value=Biotechnology>Biotechnology</option>      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value=Biotechnology>Biotechnology</option>
			    </c:otherwise>
			</c:choose>		
	        
	      </select>
	    </div>
	  </div>
	
	  	<button type="submit" class="btn btn-primary submitButton">Submit</button>

	  
	  
	</form>
	</c:if>
		
	<c:if test="${modifystatus == 'success' }">
		<p class="text-center">Modified Successfully.</p>
	</c:if>
	<c:if test="${modifystatus == 'statefail' }">
		<p class="text-center">Please select a state.</p>
	</c:if>
</div>