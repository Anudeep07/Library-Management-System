package issue;

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

import database.BookDatabaseObject;
import database.StudentDatabaseObject;
import login.LoginDatabase;

@WebServlet("/ShowBorrow")
public class ShowBorrow extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "showborrowbook");
		
		int borrowid = Integer.parseInt(request.getParameter("borrowid"));
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BORROW WHERE Borrow_id = ?;";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, borrowid);
			ResultSet rs = statement.executeQuery();		
		
			rs.next();
			
			//int borrowid = rs.getInt(1) ;
			String bookid = rs.getString(2);			
			String studentid = rs.getString(4);
			String issuedate = rs.getString(5);
			String returndate = rs.getString(6);
			
			request.setAttribute("issuedate", issuedate);
			request.setAttribute("returndate", returndate);
		
			String query1 = "SELECT * FROM STUDENT WHERE Student_id = ?";
		
		
			statement = connection.prepareStatement(query1);
			statement.setString(1, studentid);
			rs = statement.executeQuery();
			
			rs.next();			
			
			String firstname = rs.getString("FirstName");
			String lastname = rs.getString("SecondName");
			int semester = rs.getInt("Semester");
			String department = rs.getString("Department");
			int booksborrowed = rs.getInt("BooksBorrowed");
			
			
		StudentDatabaseObject student = new StudentDatabaseObject(studentid,firstname,lastname,semester,department,
					booksborrowed);
		request.setAttribute("student", student);
				
		String query2 = "SELECT * FROM BOOK WHERE ISBN=?;";
		
			statement = connection.prepareStatement(query2);
			statement.setString(1, bookid);
			rs = statement.executeQuery();
			
			rs.next();
						
			String title = rs.getString("BookTitle");
			String author = rs.getString("Author");
			int quantity = rs.getInt("AvailableQuantity");
			
			
			
			BookDatabaseObject book = new BookDatabaseObject(Long.parseLong(bookid), title, author, quantity);
			request.setAttribute("book", book);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
