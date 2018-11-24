<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<div class="container topmarginlib">

	<form method="post" action="ReturnBook">

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
	      <th scope="col">Borrow ID</th>
	      <th scope="col">ISBN</th>
	      <th scope="col">Student ID</th>
	      <th scope="col">Issue Date</th>	      
	      <th scope="col">Return Date</th>
	      <th scope="col">Details</th>
	      <th scope="col">Return</th>		  	      	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="borrow" items="${borrowList }">
	
		  	<tr>
		      <th scope="row">${borrow.borrowid } </th>
		      <td>${borrow.bookid }</td>
		      <td>${borrow.studentid }</td>
		      <td>${borrow.issuedate }</td>
		      <td>${borrow.returndate }</td>
		      <td><button onclick="location.href='ShowBorrow?borrowid=${borrow.borrowid }'" type="button" class="btn btn-secondary">View</button></td>		      
		      <td><button onclick="location.href='ReturnBookComplete?borrowid=${borrow.borrowid }'" type="button" class="btn btn-secondary">Return</button></td>
		    </tr>	
	  	
	  	</c:forEach>
	  
	  </tbody>
	</table>	
	
	<c:if test="${removestatus != null }">
			<p class="text-center">${removestatus }</p>
	</c:if>

	
</div>