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
    	      <li class="nav-item">
		        <a class="nav-link" href="SearchBook" role="button">
					<i class="fas fa-book"></i>Search Books
		        </a>
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
	
