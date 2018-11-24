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


@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	
	final static String SALT = "MmEQIecP5L0B";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addadmin");
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addadmin");
		
		String username = request.getParameter("adminid");
		
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
				
				String password = LoginDatabase.generateHash(username + SALT);
				String role = "ADMIN";
			
				
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, role);
				
				statement.executeUpdate();	
				
				request.setAttribute("addstatus", "success");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

}
