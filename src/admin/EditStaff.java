package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginDatabase;
import database.LibrarianDatabaseObject;

@WebServlet("/EditStaff")
public class EditStaff extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setAttribute("status", "editstaff");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM LIBRARIAN ORDER BY FirstName;";
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();			
			ArrayList<LibrarianDatabaseObject> librarianList = new ArrayList<LibrarianDatabaseObject>();
			
			while(rs.next()) {
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Librarian_id = rs.getString("Librarian_id");
				String Address = rs.getString("Address");
				String City = rs.getString("City");
				String State = rs.getString("State");
				
				LibrarianDatabaseObject temp = new LibrarianDatabaseObject(FirstName, LastName, Librarian_id, Address, City, State);
				librarianList.add(temp);
			}
			
			request.setAttribute("librarianList", librarianList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "editstaff");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM LIBRARIAN WHERE FirstName LIKE ? ORDER BY FirstName;";
		String searchtext = request.getParameter("searchbox");
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchtext + "%");
			ResultSet rs = statement.executeQuery();			
			ArrayList<LibrarianDatabaseObject> librarianList = new ArrayList<LibrarianDatabaseObject>();
			
			while(rs.next()) {
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Librarian_id = rs.getString("Librarian_id");
				String Address = rs.getString("Address");
				String City = rs.getString("City");
				String State = rs.getString("State");
				
				LibrarianDatabaseObject temp = new LibrarianDatabaseObject(FirstName, LastName, Librarian_id, Address, City, State);
				librarianList.add(temp);
			}
			
			request.setAttribute("librarianList", librarianList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
		
	}

}
