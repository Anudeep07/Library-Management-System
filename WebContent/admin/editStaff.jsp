<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<form method="post" action="EditStaff">

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
	      <th scope="col">Username</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Address</th>
	      <th scope="col">City</th>
	      <th scope="col">State</th>
	      <th scope="col">Modify</th>
	      <th scope="col">Delete</th>	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="librarian" items="${librarianList }">
	
		  	<tr>
		      <th scope="row">${librarian.username } </th>
		      <td>${librarian.firstname }</td>
		      <td>${librarian.lastname }</td>
		      <td>${librarian.address }</td>
		      <td>${librarian.city }</td>
		      <td>${librarian.state }</td>
		      <td><button onclick="location.href='ModifyStaff?user=${librarian.username }'" type="button" class="btn btn-secondary">Modify</button></td>
		      <td><button onclick="location.href='RemoveStaff?user=${librarian.username }'" type="button" class="btn btn-secondary" value="Anudeep07">Delete</button></td>
		    </tr>	
	  	
	  	</c:forEach>
	  
	  </tbody>
	</table>	
	
	<c:if test="${removestatus != null }">
			<p class="text-center">${removestatus }</p>
	</c:if>

</div>