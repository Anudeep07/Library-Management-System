<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<form method="post" action="RemoveAdmin">

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
	      <th>Delete</th> 
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="admin" items="${adminList }">
	
		  	<tr>
		      <th scope="row">${admin } </th>
		      <td><button onclick="location.href='DeleteAdmin?user=${admin }'" type="button" class="btn btn-secondary">Delete</button></td>
		    </tr>	
	  	
	  	</c:forEach>
	  
	  </tbody>
	</table>	
	
	<c:if test="${removestatus != null }">
			<p class="text-center">${removestatus }</p>
	</c:if>

</div>