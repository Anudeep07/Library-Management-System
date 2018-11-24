package issue;

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

import database.BookDatabaseObject;
import database.StudentDatabaseObject;
import login.LoginDatabase;

@WebServlet("/IssueBookAddStudent")
public class IssueBookAddStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "issuebook");
		request.setAttribute("issuestatus", "student");
		
		String isbn = request.getParameter("isbn");
		request.setAttribute("bookisbn", isbn);
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM STUDENT ORDER BY FirstName;";
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();			
			ArrayList<StudentDatabaseObject> studentList = new ArrayList<StudentDatabaseObject>();
			
			while(rs.next()) {
									
				String studentid = rs.getString("Student_id");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("SecondName");
				int semester = rs.getInt("Semester");
				String department = rs.getString("Department");
				int booksborrowed = rs.getInt("BooksBorrowed");
				
				StudentDatabaseObject temp = new StudentDatabaseObject(studentid,firstname,lastname,semester,department,
						booksborrowed);
				studentList.add(temp);
			}
			
			request.setAttribute("studentList", studentList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "issuebook");
		request.setAttribute("issuestatus", "student");
		
		String isbn = request.getParameter("isbn");
		request.setAttribute("bookisbn", isbn);
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM STUDENT WHERE FirstName LIKE ? ORDER BY FirstName;";
		String searchtext = request.getParameter("searchbox");
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchtext + "%");
			ResultSet rs = statement.executeQuery();			
			ArrayList<StudentDatabaseObject> studentList = new ArrayList<StudentDatabaseObject>();
			
			while(rs.next()) {
				String studentid = rs.getString("Student_id");
				String firstname = rs.getString("FirstName");
				String lastname = rs.getString("SecondName");
				int semester = rs.getInt("Semester");
				String department = rs.getString("Department");
				int booksborrowed = rs.getInt("BooksBorrowed");
				
				StudentDatabaseObject temp = new StudentDatabaseObject(studentid,firstname,lastname,semester,department,
						booksborrowed);
				studentList.add(temp);
			}
			
			request.setAttribute("studentList", studentList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}
}
