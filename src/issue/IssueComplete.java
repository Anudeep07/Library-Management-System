package issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

import database.BookDatabaseObject;
import database.StudentDatabaseObject;
import login.LoginDatabase;

@WebServlet("/IssueComplete")
public class IssueComplete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("status", "issuebook");
		request.setAttribute("issuestatus", "complete");
		
		String username = request.getParameter("user"); 
		long isbn = Long.parseLong(request.getParameter("isbn"));
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query1 = "SELECT * FROM STUDENT WHERE Student_id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query1);
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
		
		String query2 = "SELECT * FROM BOOK WHERE ISBN=?;";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query2);
			statement.setLong(1, isbn);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
						
			String title = rs.getString("BookTitle");
			String author = rs.getString("Author");
			int quantity = rs.getInt("AvailableQuantity");
			
			
			BookDatabaseObject book = new BookDatabaseObject(isbn, title, author, quantity);
			request.setAttribute("book", book);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	

		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String strisbn = request.getParameter("isbn");
		
		if(username == null || strisbn == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);	
			return;
		}
		
		long ISBN = Long.parseLong(strisbn);
		
		String query1 = "SELECT BooksBorrowed FROM STUDENT WHERE Student_id = ?";
		Connection connection = LoginDatabase.getConnectionToMySQL();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query1);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			rs.next();			
			
			int booksborrowed = rs.getInt("BooksBorrowed");
			
			
			if(booksborrowed == 3) {
				//can't borrow more than 3 books				
				request.setAttribute("completestatus", "Borrow failed because " + username + " has already borrowed 3 books!");
				doGet(request, response);
			} else {
				
				String query2 = "SELECT AvailableQuantity FROM BOOK WHERE ISBN = ?";
				
				statement = connection.prepareStatement(query2);
				statement.setLong(1, ISBN);
				rs = statement.executeQuery();
				
				rs.next();
							
				int quantity = rs.getInt("AvailableQuantity");
				
				if(quantity == 0) {
					//can't borrow because no books available
					request.setAttribute("completestatus", "Borrow failed because no books available right now! Please try later.");
					doGet(request, response);
				} else {
					
					HttpSession session = request.getSession();
					String librarianid = (String) session.getAttribute("username");
					String issuedate = request.getParameter("issuedate");
					String returndate = request.getParameter("returndate");
					
					String query3 = "UPDATE STUDENT SET BooksBorrowed = ? WHERE Student_id = ?";
					
					statement = connection.prepareStatement(query3);
					statement.setInt(1, booksborrowed+1);
					statement.setString(2, username);
					statement.executeUpdate();
					
					String query4 = "UPDATE BOOK SET AvailableQuantity = ? WHERE ISBN = ?";
					
					statement = connection.prepareStatement(query4);
					statement.setInt(1, quantity-1);
					statement.setLong(2, ISBN);
					statement.executeUpdate();
					
					String query5 = "INSERT INTO BORROW(Bookid, Librarianid, Studentid, Issuedate, Returndate) VALUES(?, ?, ?, ?, ?)";
					
					statement = connection.prepareStatement(query5);
					statement.setLong(1, ISBN);
					statement.setString(2, librarianid);
					statement.setString(3, username); 	//studentid
					statement.setString(4, issuedate);
					statement.setString(5, returndate);
					statement.executeUpdate();
					
					
					request.setAttribute("completestatus", "Successfully issued to " + username);
					
					request.setAttribute("status", "issuebook");
					request.setAttribute("issuestatus", "complete");
					
					RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
					rd.forward(request, response);	
				}
		
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
