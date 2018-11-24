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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
       
	final static String SALT = "MmEQIecP5L0B";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addstudent");
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department = request.getParameter("Department");
		request.setAttribute("status", "addstudent");
		
		if(department.equals("0")) {			
			request.setAttribute("addstatus", "statefail");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			
			
			String studentid = request.getParameter("studentid");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			int semester = Integer.parseInt(request.getParameter("Semester"));
			int booksborrowed = 0;
			
			
			Connection connection = LoginDatabase.getConnectionToMySQL();
			
			String query1 = "SELECT * FROM LOGIN WHERE Username = ?";
			try {
				
				PreparedStatement statement = connection.prepareStatement(query1);
				statement.setString(1, studentid);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()) {
					request.setAttribute("addstatus", "duplicateuser");
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				} else {
					
					String query2 = "INSERT INTO LOGIN VALUES(?,?,?)";
					statement = connection.prepareStatement(query2);
					
					String hashedPassword = LoginDatabase.generateHash(studentid + SALT);
					String role = "STUDENT";
					
					statement.setString(1, studentid);
					statement.setString(2, hashedPassword);
					statement.setString(3, role);
					
					statement.executeUpdate();	//finished adding to login table, now we have to add to librarian table
					
					String query3 = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
					statement = connection.prepareStatement(query3);
					
					statement.setString(1, studentid);
					statement.setString(2, firstname);
					statement.setString(3, lastname);
					statement.setInt(4, semester);
					statement.setString(5, department);
					statement.setInt(6, booksborrowed);
					
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
