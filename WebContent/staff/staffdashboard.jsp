<%	
	response.sendRedirect("../dashboard.jsp");		
%>
	
<div class="jumbotron">
	<h1 class="display-4">Welcome, ${username }</h1>
	<label class="lead" id="todaydate"></label>
</div>

<div class="container">
	<div class="row">
	  <div class="col-sm-6">
	    <div class="card  text-center">
	      <div class="card-body">
	        <h2 class="card-title">Issue Books</h2>	        
	        <a href="IssueBook" class="btn btn-danger">Issue</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6">
	   	 <div class="card text-center">
	      <div class="card-body">
	        <h2 class="card-title">Return Books</h2>	        
	        <a href="ReturnBook" class="btn btn-danger">Return</a>
	      </div>
	    </div>
 	 </div>
	</div>
</div>


<script>
	function getDate() {
		document.getElementById('todaydate').innerHTML = new Date();	
	}

	getDate();
	setInterval(getDate, 1000);
	
</script>