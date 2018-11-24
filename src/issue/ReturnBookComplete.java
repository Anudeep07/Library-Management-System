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
import javax.servlet.http.HttpSession;

import database.BorrowDatabaseObject;
import login.LoginDatabase;

@WebServlet("/ReturnBookComplete")
public class ReturnBookComplete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
			
			String query2 = "SELECT AvailableQuantity FROM BOOK WHERE ISBN = ?";
			statement = connection.prepareStatement(query2);
			statement.setString(1, bookid);
			
			rs = statement.executeQuery();
			
			rs.next();
			
			int quantity = rs.getInt("AvailableQuantity");
			
			String query3 = "UPDATE BOOK SET AvailableQuantity = ? WHERE ISBN = ?";
			statement = connection.prepareStatement(query3);
			statement.setInt(1, quantity+1);
			statement.setString(2, bookid);
			
			statement.executeUpdate();
			
			String query4 = "SELECT BooksBorrowed FROM STUDENT WHERE Student_id = ?";
			statement = connection.prepareStatement(query4);
			statement.setString(1, studentid);
			
			rs = statement.executeQuery();
			
			rs.next();
			
			int booksborrowed = rs.getInt("BooksBorrowed");
			
			String query5 = "UPDATE STUDENT SET BooksBorrowed = ? WHERE Student_id = ?";
			statement = connection.prepareStatement(query5);
			statement.setInt(1, booksborrowed-1);
			statement.setString(2, studentid);
			
			statement.executeUpdate();
			
			String query6 = "DELETE FROM BORROW WHERE Borrow_id = ?";
			statement = connection.prepareStatement(query6);
			statement.setInt(1, borrowid);
			
			statement.executeUpdate();
			
			request.setAttribute("removestatus", "Successfully Returned!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ReturnBook");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
