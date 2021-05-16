package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBLogin {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://remotemysql.com:3306/v0tRUCkz6q";
	private static String username = "v0tRUCkz6q";
	private static String password = "GHrXcD7ytV";
	
		public boolean validate(User user) throws Exception {
			boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			String sql = "SELECT * FROM JDBC_USER WHERE USERNAME = ? AND PASSWORD = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch(Exception e) {
			throw e;
		}
		return status;
	}
}
