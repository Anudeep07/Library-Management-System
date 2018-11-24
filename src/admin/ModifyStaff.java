package admin;

import java.io.IOException;
import java.io.PrintWriter;
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

import database.LibrarianDatabaseObject;
import login.LoginDatabase;

@WebServlet("/ModifyStaff")
public class ModifyStaff extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setAttribute("status", "modifystaff");
		String username = request.getParameter("user");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM LIBRARIAN WHERE Librarian_id=?;";
	
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
			
			String fname = rs.getString("FirstName");
			String lname = rs.getString("LastName");			
			String Address = rs.getString("Address");
			String City = rs.getString("City");
			String State = rs.getString("State");
			
			
			LibrarianDatabaseObject librarian = new LibrarianDatabaseObject(fname,lname,username,Address,City,State);
			request.setAttribute("librarian", librarian);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state = request.getParameter("State");
		request.setAttribute("status", "modifystaff");
		
		if(state.equals("0")) {			
			request.setAttribute("modifystatus", "statefail");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String username = request.getParameter("librarianid");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			
			Connection connection = LoginDatabase.getConnectionToMySQL();
			
			String query =  "UPDATE LIBRARIAN SET FirstName = ?, LastName = ?, Address = ?, City = ?, State = ? WHERE Librarian_id = ?";
			
			try {
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, firstName);
				statement.setString(2, lastName);
				statement.setString(3, address);
				statement.setString(4, city);
				statement.setString(5, state);
				statement.setString(6, username);
				
				statement.executeUpdate();
				
				request.setAttribute("modifystatus", "success");
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}	
	}

}
