package admin;

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

import database.LibrarianDatabaseObject;
import login.LoginDatabase;


@WebServlet("/RemoveAdmin")
public class RemoveAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "removeadmin");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM LOGIN WHERE Role = 'ADMIN' ORDER BY Username;";
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();			
			ArrayList<String> adminList = new ArrayList<String>();
			
			while(rs.next()) {
				String Username = rs.getString("Username");
								
				adminList.add(Username);
			}
			
			request.setAttribute("adminList", adminList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status", "removeadmin");
		
		Connection connection = LoginDatabase.getConnectionToMySQL();
		String query = "SELECT * FROM LOGIN WHERE Username LIKE ? AND Role = 'ADMIN' ORDER BY Username;";
		String searchtext = request.getParameter("searchbox");
						
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "%" + searchtext + "%");
			ResultSet rs = statement.executeQuery();			
			ArrayList<String> adminList = new ArrayList<String>();
			
			while(rs.next()) {
				String Username = rs.getString("Username");
				
				adminList.add(Username);
			}
			
			request.setAttribute("adminList", adminList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}

}
