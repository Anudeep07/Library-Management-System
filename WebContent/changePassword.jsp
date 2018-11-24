<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">
	<div class="page-header text-center">
		<h2>Change Password</h1>
	</div>	
	<hr>
	
	<form method="post" action="ChangePassword">
	    <div class="form-group">
	      <label for="oldp">Old Password</label>
	      <input type="password" class="form-control" id="oldp" name="oldpassword"  placeholder="Old Password" required>
	    </div>
	  <div class="form-group">
	    <label for="newp">New Password</label>
	    <input type="password" class="form-control" id="newp" name="newpassword" placeholder="New Password" required>
	  </div>
	  
	    <div class="form-group">
	      <label for="confirmp">Confirm New Password</label>
	      <input type="password" class="form-control" id="confirmp" name="confirmpassword" placeholder="Confirm Password" required>
	    </div>
	  
	  <button type="submit" class="btn btn-primary submitButton">Submit</button>
	</form>
	
	<c:if test="${changestatus != null }">
			<p class="text-center">${changestatus }</p>
	</c:if>
		
	
</div>