package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class DBAdmin
 */
@WebServlet("/admin2")
public class DBAdmin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://remotemysql.com:3306/v0tRUCkz6q";
	private static String username = "v0tRUCkz6q";
	private static String password = "GHrXcD7ytV";
		
			
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] perc = new String[5];
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			int bank = Integer.parseInt(request.getParameter("bank"));
			String percent = request.getParameter("percent");
			
			PreparedStatement ps = con.prepareStatement("UPDATE Banks SET PERCENT = ? WHERE ID = ?");
			System.out.print(bank);
			System.out.print(percent);
			ps.setString(1, percent);
			ps.setInt(2, bank);
			ps.executeUpdate();
		    ps.close();

            response.sendRedirect("premain.jsp");

		} catch(Exception e) {

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}