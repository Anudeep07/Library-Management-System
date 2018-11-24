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
	        <h2 class="card-title">Add Students</h2>	        
	        <a href="AddStudent" class="btn btn-danger">Add</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6">
	   	 <div class="card text-center">
	      <div class="card-body">
	        <h2 class="card-title">Edit Students</h2>	        
	        <a href="EditStudent" class="btn btn-danger">Edit</a>
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