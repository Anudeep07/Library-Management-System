package staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDatabase;

@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("isbn") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);	
			return;
		}
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BORROW WHERE Bookid = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, isbn);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				//book has been borrowed by some student, therefore can't delete this book
				request.setAttribute("removestatus", "Unable to delete because this book has been issued by atleast one student.");
			} else {
				String query2 = "DELETE FROM BOOK WHERE ISBN = ?";
				statement = connection.prepareStatement(query2);
				statement.setLong(1, isbn);
				
				statement.executeUpdate();
				
				request.setAttribute("removestatus", "Successfully deleted." );
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/EditBook");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
