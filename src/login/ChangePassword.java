package login;

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
import javax.servlet.http.HttpSession;


@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	
	final static String SALT = "MmEQIecP5L0B";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "changepassword");
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "changepassword");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		
		if(!newpassword.equals(confirmpassword)) {
			request.setAttribute("changestatus", "New password and confirm password doesn't match.");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			return;
		}
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String hashedPassword = LoginDatabase.generateHash(oldpassword + SALT);
		
		String query1 = "SELECT * FROM LOGIN WHERE Username = ? AND Password = ?";
		
		PreparedStatement statement;
		try {			
			statement = connection.prepareStatement(query1);
			statement.setString(1, username);
			statement.setString(2, hashedPassword);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				//update password
				String query2 = "UPDATE LOGIN SET Password = ? WHERE Username = ?";
				statement = connection.prepareStatement(query2);
				
				String newpass = LoginDatabase.generateHash(newpassword + SALT);
				
				statement.setString(1, newpass);
				statement.setString(2, username);
				
				statement.executeUpdate();
				request.setAttribute("changestatus", "Password updated successfully!");
				
			} else {
				//wrong password
				request.setAttribute("changestatus", "Invalid Password.");
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				return;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);		
	}

}
