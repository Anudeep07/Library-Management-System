package library.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	Connection connection;
	final static String SALT = "MmEQIecP5L0B";
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	connection = LoginDataBase.getConnectionToMySQL();
    	
    	try {

			String query = "SELECT * FROM LOGIN WHERE Username = ? AND Password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			String hashedPassword = LoginDataBase.generateHash(password + SALT);
			
			statement.setString(1, username);
			statement.setString(2,hashedPassword);
			
			ResultSet resultSet =  statement.executeQuery();
			
			if(resultSet.next()) {
				HttpSession session = request.getSession();
				
				String role = resultSet.getString("Role");
				
				session.setAttribute("username", username);
				session.setAttribute("role", role);

				response.sendRedirect("dashboard.jsp");
				
				/*
				if(role.equals("ADMIN")) {
					//admin
					response.sendRedirect("admin/admindashboard.jsp");
				} else if(role.equals("LIBRARIAN")) {
					//librarian
					response.sendRedirect("librarian/librariandashboard.jsp");
				} else {
					//student
					response.sendRedirect("student/studentdashboard.jsp");
				}				
				*/
				
			} else {
				response.sendRedirect("index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
