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
	<form method="post" action="ModifyBook">
	  
	    <div class="form-group">
	      <label for="title">Book Title</label>
	      <input type="text" class="form-control" id="title" name="title" value="${book.title }"  placeholder="Title" required>
	    </div>
	  
	  <div class="form-group">
	    <label for="isbn">ISBN</label>
	    <input type="text" class="form-control" id="isbn" name="isbn" value="${book.isbn }" placeholder="ISBN" required readonly>
	  </div>
	  <div class="form-row">
	  	<div class="form-group col-md-6">
	    	<label for="author">Book Author</label>
	  		<input type="text" class="form-control" id="author" name="author" value="${book.author }" placeholder="Author" required>
	  	</div>
	  	<div class="form-group col-md-6">
		    <label for="quantity">Quantity</label>
		    <input type="number" class="form-control" id="quantity" name="quantity" value="${book.quantity }"  min="1" placeholder="Quantity" required>
		  </div>
	  </div>
	  	  
	
	  <button type="submit" class="btn btn-primary submitButton">Submit</button>
	</form>
	
	</c:if>
		
	<c:if test="${modifystatus == 'success' }">
		<p class="text-center">Modified Successfully.</p>
	</c:if>
</div>