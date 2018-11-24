<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%	
	response.sendRedirect("../dashboard.jsp");		
%>



<div class="container topmarginlib">
	
	<div class="page-header text-center">
		<h2>Modify Staff</h1>
	</div>
	
	<hr>
	
	
  <c:if test="${modifystatus != null }">
  	<button onclick="location.href='dashboard.jsp'" class="btn btn-primary submitButton">Return to dashboard</button>
  </c:if>
  <c:if test="${modifystatus == null }">
	<form method="post" action="ModifyStaff">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="firstname">First Name</label>
	      <input type="text" class="form-control" id="firstname" name="fname" value="${librarian.firstname }"  placeholder="First Name" required>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="lastname">Last Name</label>
	      <input type="text" class="form-control" id="lastname" name="lname" value="${librarian.lastname }" placeholder="Last Name" required>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="userid">Librarian ID</label>
	    <input type="text" class="form-control" id="userid" name="librarianid" value="${librarian.username }" placeholder="Librarian ID" required readonly>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" name="address" value="${librarian.address }" placeholder="Address" required>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">City</label>
	      <input type="text" class="form-control" id="inputCity" name="city" value="${librarian.city }" placeholder="City" required>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputState">State</label>
	      <select id="inputState" class="form-control" name="State">
	        <option value=0>Choose...</option>
	        
	        <c:choose>
			    <c:when test="${librarian.state == 'Karnataka'}">
			        <option selected value=Karnataka>Karnataka</option>			      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value=Karnataka>Karnataka</option>
			    </c:otherwise>
			</c:choose>
			
			<c:choose>
			    <c:when test="${librarian.state == 'Andhra Pradesh'}">
			        <option selected value="Andra Pradesh">Andhra Pradesh</option>	      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value="Andhra Pradesh">Andhra Pradesh</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${librarian.state == 'Maharashtra'}">
			        <option selected value=Maharashtra>Maharashtra</option>		      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value=Maharashtra>Maharashtra</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${librarian.state == 'Kerala'}">
			        <option selected value=Kerala>Kerala</option>			      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value=Kerala>Kerala</option>
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${librarian.state == 'Tamil Nadu'}">
			        <option selected value="Tamil Nadu">Tamil Nadu</option>      
			    </c:when>    
			    <c:otherwise>			    
			    	<option value="Tamil Nadu">Tamil Nadu</option>
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