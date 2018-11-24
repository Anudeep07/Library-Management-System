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

import database.BookDatabaseObject;
import database.BorrowDatabaseObject;
import database.StudentDatabaseObject;
import login.LoginDatabase;


@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "returnbook");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BORROW WHERE Librarianid = ? ORDER BY Returndate;";
		HttpSession session = request.getSession();
		String librarianid = (String) session.getAttribute("username");
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, librarianid);
			ResultSet rs = statement.executeQuery();			
			ArrayList<BorrowDatabaseObject> borrowList = new ArrayList<BorrowDatabaseObject>();
			
			while(rs.next()) {
				int borrowid = rs.getInt(1) ;
				String bookid = rs.getString(2);
				//String librarianid = rs.getString(3);
				String studentid = rs.getString(4);
				String issuedate = rs.getString(5);
				String returndate = rs.getString(6);
				
				
				BorrowDatabaseObject temp = new BorrowDatabaseObject(borrowid, bookid, librarianid, studentid, issuedate, returndate);
				borrowList.add(temp);
			}
			
			request.setAttribute("borrowList", borrowList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "returnbook");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM BORROW WHERE Studentid LIKE ? ORDER BY Returndate, Studentid;";
		String searchtext = request.getParameter("searchbox");
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchtext + "%");
			ResultSet rs = statement.executeQuery();			
			ArrayList<BorrowDatabaseObject> borrowList = new ArrayList<BorrowDatabaseObject>();
			
			while(rs.next()) {
				int borrowid = rs.getInt(1) ;
				String bookid = rs.getString(2);
				String librarianid = rs.getString(3);
				String studentid = rs.getString(4);
				String issuedate = rs.getString(5);
				String returndate = rs.getString(6);
				
				
				BorrowDatabaseObject temp = new BorrowDatabaseObject(borrowid, bookid, librarianid, studentid, issuedate, returndate);
				borrowList.add(temp);
			}
			
			request.setAttribute("borrowList", borrowList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	
	}

}
