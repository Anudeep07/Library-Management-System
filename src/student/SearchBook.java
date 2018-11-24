package student;

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
import login.LoginDatabase;

@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "searchbook");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BOOK ORDER BY BookTitle;";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();			
			ArrayList<BookDatabaseObject> bookList = new ArrayList<BookDatabaseObject>();
			
			while(rs.next()) {
				long isbn = rs.getLong("ISBN");
				String title = rs.getString("BookTitle");
				String author = rs.getString("Author");
				int quantity = rs.getInt("AvailableQuantity");
				
				BookDatabaseObject temp = new BookDatabaseObject(isbn, title, author, quantity);
				bookList.add(temp);
			}
			
			request.setAttribute("bookList", bookList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "searchbook");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BOOK WHERE BookTitle LIKE ? ORDER BY BookTitle;";
		String searchtext = request.getParameter("searchbox");
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchtext + "%");
			ResultSet rs = statement.executeQuery();			
			ArrayList<BookDatabaseObject> bookList = new ArrayList<BookDatabaseObject>();
			
			while(rs.next()) {
				long isbn = rs.getLong("ISBN");
				String title = rs.getString("BookTitle");
				String author = rs.getString("Author");
				int quantity = rs.getInt("AvailableQuantity");
				
				BookDatabaseObject temp = new BookDatabaseObject(isbn, title, author, quantity);
				bookList.add(temp);
			}
			
			request.setAttribute("bookList", bookList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
		


	}

}
