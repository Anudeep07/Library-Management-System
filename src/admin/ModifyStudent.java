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

import database.StudentDatabaseObject;
import login.LoginDatabase;

@WebServlet("/ModifyStudent")
public class ModifyStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("status", "modifystudent");
		String username = request.getParameter("user");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM STUDENT WHERE Student_id=?;";
	
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
			
			
			String firstname = rs.getString("FirstName");
			String lastname = rs.getString("SecondName");
			int semester = rs.getInt("Semester");
			String department = rs.getString("Department");
			int booksborrowed = rs.getInt("BooksBorrowed");
			
			
			StudentDatabaseObject student = new StudentDatabaseObject(username,firstname,lastname,semester,department,
					booksborrowed);
			request.setAttribute("student", student);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String department = request.getParameter("Department");
		request.setAttribute("status", "modifystudent");
		
		if(department.equals("0")) {			
			request.setAttribute("modifystatus", "statefail");
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} else {
			
			String studentid = request.getParameter("studentid");
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			int semester = Integer.parseInt(request.getParameter("Semester"));
			int booksborrowed = 0;
			
			Connection connection = LoginDatabase.getConnectionToMySQL();
			
			String query =  "UPDATE STUDENT SET FirstName = ?, SecondName = ?, Semester = ?, Department = ?, BooksBorrowed = ? WHERE Student_id = ?";
			
			try {
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, firstname);
				statement.setString(2, lastname);
				statement.setInt(3, semester);
				statement.setString(4, department);
				statement.setInt(5, booksborrowed);
				
				statement.executeUpdate();
				
				request.setAttribute("modifystatus", "success");
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}	
	}

}
