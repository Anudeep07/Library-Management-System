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
					<i class="fas fa-book"></i>Manage Books
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="AddBook"><i class="fas fa-plus"></i>Add</a>
		          <a class="dropdown-item" href="EditBook"><i class="far fa-edit"></i>Edit</a>		          
		        </div>
		      </li>
		      
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-book-reader"></i>Manage Library
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="IssueBook"><i class="far fa-plus-square"></i>Issue</a>
		          <a class="dropdown-item" href="ReturnBook"><i class="fas fa-exchange-alt"></i>Return</a>
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
		    				<a class="dropdown-item" href="ChangePassword"><i class="fas fa-key"></i>Change Password</a>
		    			</div>
		    		</li>
		    	</ul>

		    	<button class="btn btn-danger my-2 my-sm-0" type="submit">Log out</button>
		    </form>
		</div>
	</nav>
	
