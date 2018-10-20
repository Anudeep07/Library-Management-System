package library.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDataBase {

	private static Connection connection;
	
	public static Connection getConnectionToMySQL() {
		
		try {
			connection = null;
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
			System.out.println("suc");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver failed to load.");
		} catch (SQLException e) {
			System.err.println("SQL Exception Occured.");
		}
		
		return connection;
	}
	
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash.toString();
	}
	
	public static void main(String args[]) {
		getConnectionToMySQL();
	}
}
