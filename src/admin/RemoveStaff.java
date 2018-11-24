package admin;

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

@WebServlet("/RemoveStaff")
public class RemoveStaff extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);	
			return;
		}
		
//		request.setAttribute("status", "editstaff");
		String username = request.getParameter("user");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BORROW WHERE Librarianid = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				//librarian has issued a book to some student, therefore can't delete that librarian
				request.setAttribute("removestatus", "Unable to delete because " + username + " has issued atleast one book.");
			} else {
				String query2 = "DELETE FROM LOGIN WHERE Username = ?";
				statement = connection.prepareStatement(query2);
				statement.setString(1, username);
				
				statement.executeUpdate();
				
				request.setAttribute("removestatus", "Successfully deleted " +  username + "." );
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/EditStaff");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
