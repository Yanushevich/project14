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
@WebServlet("/admin")
public class DBAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://remotemysql.com:3306/v0tRUCkz6q";
	private static String username = "v0tRUCkz6q";
	private static String password = "GHrXcD7ytV";
		
			
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] perc = new String[6];
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Banks");
			
			while(resultSet.next()){
                perc[resultSet.getInt(1)] = resultSet.getString(2);
                System.out.println(resultSet.getString(2));
            }
            
           
		} catch(Exception e) {
			
		}
		
		request.setAttribute("perc1", perc[1]);
        request.setAttribute("perc2", perc[2]);
        request.setAttribute("perc3", perc[3]);
        request.setAttribute("perc4", perc[4]);
        request.setAttribute("perc5", perc[5]);
        
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}