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

import database.BookDatabaseObject;
import login.LoginDatabase;

@WebServlet("/ModifyBook")
public class ModifyBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setAttribute("status", "modifybook");
		long isbn = Long.parseLong(request.getParameter("isbn"));
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BOOK WHERE ISBN=?;";
	
		try {
			PreparedStatement statement = connection.prepareStatement(query);
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
		
		request.setAttribute("status", "modifybook");
		
		long isbn = Long.parseLong(request.getParameter("isbn"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "UPDATE BOOK SET BookTitle = ?, Author = ?, AvailableQuantity = ? WHERE ISBN = ?";
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, title);
			statement.setString(2, author);
			statement.setInt(3, quantity);
			statement.setLong(4, isbn);
			
			statement.executeUpdate();
			
			request.setAttribute("modifystatus", "success");			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}

}
