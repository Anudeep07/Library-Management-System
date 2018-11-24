<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">
	<div class="page-header text-center">
		<h2>Add Staff</h1>
	</div>
	
	<hr>
	<form method="post" action="AddStaff">
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
	    <label for="userid">Librarian ID</label>
	    <input type="text" class="form-control" id="userid" name="librarianid" placeholder="Librarian ID" required>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" name="address" placeholder="Address" required>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">City</label>
	      <input type="text" class="form-control" id="inputCity" name="city" placeholder="City" required>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputState">State</label>
	      <select id="inputState" class="form-control" name="State">
	        <option selected value=0>Choose...</option>
	        <option value=Karnataka>Karnataka</option>
	        <option value="Andhra Pradesh">Andhra Pradesh</option>
	        <option value=Maharashtra>Maharashtra</option>
	        <option value=Kerala>Kerala</option>
	        <option value="Tamil Nadu">Tamil Nadu</option>
	      </select>
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
		<p>Please select a state.</p>
	</c:if>
</div>