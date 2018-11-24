<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<form method="post" action="EditBook">

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
	      <th scope="col">ISBN</th>
	      <th scope="col">Title</th>
	      <th scope="col">Author</th>
	      <th scope="col">Quantity</th>	      
	      <th scope="col">Modify</th>
	      <th scope="col">Delete</th>	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="book" items="${bookList }">
	
		  	<tr>
		      <th scope="row">${book.isbn } </th>
		      <td>${book.title }</td>
		      <td>${book.author }</td>
		      <td>${book.quantity }</td>
		      <td><button onclick="location.href='ModifyBook?isbn=${book.isbn }'" type="button" class="btn btn-secondary">Modify</button></td>
		      <td><button onclick="location.href='RemoveBook?isbn=${book.isbn }'" type="button" class="btn btn-secondary">Delete</button></td>
		    </tr>	
	  	
	  	</c:forEach>
	  
	  </tbody>
	</table>	
	
	<c:if test="${removestatus != null }">
			<p class="text-center">${removestatus }</p>
	</c:if>

</div>