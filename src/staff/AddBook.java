package staff;

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

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addbook");
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "addbook");
		
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String author = request.getParameter("author");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		
		String query1 = "SELECT * FROM BOOK WHERE ISBN = ?";
		
		PreparedStatement statement;
		try {
			
			statement = connection.prepareStatement(query1);
			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				request.setAttribute("addstatus", "The book already exists in the database.");
			} else {
				String query2 = "INSERT INTO BOOK VALUES(?, ?, ?, ?)";
				statement = connection.prepareStatement(query2);
				
				statement.setString(1, isbn);
				statement.setString(2, title);
				statement.setString(3, author);
				statement.setInt(4, quantity);
				
				statement.executeUpdate();
				request.setAttribute("addstatus", "Book has been successfully added!");
			}
			
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

}
