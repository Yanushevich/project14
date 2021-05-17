package web;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class GetPercentsTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://remotemysql.com:3306/v0tRUCkz6q";
		String username = "v0tRUCkz6q";
		String password = "GHrXcD7ytV";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		assertNotNull (con);
	}

}
