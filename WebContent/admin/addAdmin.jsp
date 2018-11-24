<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">
	<div class="page-header text-center">
		<h2>Add Admin</h1>
	</div>
	
	<hr>
	<form method="post" action="AddAdmin">
	 
	  <div class="form-group">
	    <label for="userid">Admin ID</label>
	    <input type="text" class="form-control" id="userid" name="adminid" placeholder="Admin ID" required>
	  </div>
	  
	  <button type="submit" class="btn btn-primary submitButton">Submit</button>
	</form>
	
	<c:if test="${addstatus == 'success' }">
		<p>Successfully added.</p>
	</c:if>
	<c:if test="${addstatus == 'duplicateuser' }">
		<p>Duplicate user.</p>
	</c:if>
</div>