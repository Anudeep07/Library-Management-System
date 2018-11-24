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



import login.LoginDatabase;

@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {
	
	final static String SALT = "MmEQIecP5L0B";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addstaff");
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state = request.getParameter("State");
		request.setAttribute("status", "addstaff");
		
		if(state.equals("0")) {			
			request.setAttribute("addstatus", "statefail");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String username = request.getParameter("librarianid");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			
			Connection connection = LoginDatabase.getConnectionToMySQL();
			
			String query1 = "SELECT * FROM LOGIN WHERE Username = ?";
			try {
				
				PreparedStatement statement = connection.prepareStatement(query1);
				statement.setString(1, username);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()) {
					request.setAttribute("addstatus", "duplicateuser");
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				} else {
					
					String query2 = "INSERT INTO LOGIN VALUES(?,?,?)";
					statement = connection.prepareStatement(query2);
					
					String hashedPassword = LoginDatabase.generateHash(username + SALT);
					String role = "LIBRARIAN";
					
					statement.setString(1, username);
					statement.setString(2, hashedPassword);
					statement.setString(3, role);
					
					statement.executeUpdate();	//finished adding to login table, now we have to add to librarian table
					
					String query3 = "INSERT INTO LIBRARIAN VALUES(?,?,?,?,?,?)";
					statement = connection.prepareStatement(query3);
					
					statement.setString(1, firstName);
					statement.setString(2, lastName);
					statement.setString(3, username);
					statement.setString(4, address);
					statement.setString(5, city);
					statement.setString(6, state);
					
					statement.executeUpdate();
					
					request.setAttribute("addstatus", "success");
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
