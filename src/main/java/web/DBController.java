package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBController {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://remotemysql.com:3306/v0tRUCkz6q";
	private static String username = "v0tRUCkz6q";
	private static String password = "GHrXcD7ytV";
	
	public static void registerUser(User user) throws Exception {
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			String sql = "INSERT INTO JDBC_USER (USERNAME, PASSWORD) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();
			System.out.println("Connection established");
			
			return;
		} catch(Exception e) {
			throw e;
		}
	}
	
}
