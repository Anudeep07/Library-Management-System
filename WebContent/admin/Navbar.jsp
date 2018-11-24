<%	
	response.sendRedirect("../dashboard.jsp");		
%>

<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<a class="navbar-brand" href="dashboard.jsp" >Dashboard</a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		  	<ul class="navbar-nav mr-auto">
    	      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-users"></i>Manage Staff
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="AddStaff"><i class="fas fa-plus"></i>Add</a>
		          <a class="dropdown-item" href="EditStaff"><i class="far fa-edit"></i>Edit</a>		          
		        </div>
		      </li>
		      
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-graduation-cap"></i>Manage Students
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="AddStudent"><i class="fas fa-plus"></i>Add</a>
		          <a class="dropdown-item" href="EditStudent"><i class="far fa-edit"></i>Edit</a>
		        </div>
		      </li>      
		      
		    </ul>
		    
		    <form class="form-inline my-2 my-lg-0" action="Logout">		    	
		    	<ul class="navbar-nav mr-sm-2">
		    		<li class="nav-item dropdown">
		    			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    				<i class="fas fa-cog"></i>Settings
		    			</a>
		    			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		    				<a class="dropdown-item" href="AddAdmin"><i class="fas fa-plus"></i>Add Admin</a>
		    				<a class="dropdown-item" href="RemoveAdmin"><i class="fas fa-times"></i>Remove Admin</a>
		    				<a class="dropdown-item" href="ChangePassword"><i class="fas fa-key"></i>Change Password</a>
		    			</div>
		    		</li>
		    	</ul>

		    	<button class="btn btn-danger my-2 my-sm-0" type="submit">Log out</button>
		    </form>
		</div>
	</nav>
	
