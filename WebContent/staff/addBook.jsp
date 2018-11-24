<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">
	<div class="page-header text-center">
		<h2>Add Book</h1>
	</div>
	
	<hr>
	<form method="post" action="AddBook">
	    <div class="form-group">
	      <label for="title">Book Title</label>
	      <input type="text" class="form-control" id="title" name="title"  placeholder="Title" required>
	    </div>
	  <div class="form-group">
	    <label for="isbn">ISBN</label>
	    <input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN" required>
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="quantity">Quantity</label>
	      <input type="number" class="form-control" id="quantity" name="quantity" value="1" min="1" required>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="author">Author</label>
	      <input type="text" class="form-control" id="author" name="author" placeholder="Author" required>
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary submitButton">Submit</button>
	</form>
	<c:if test="${addstatus != null }">
		<p class="text-center">${addstatus }</p>
	</c:if>
</div>