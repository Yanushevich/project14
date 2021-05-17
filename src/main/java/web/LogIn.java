package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBLogin dbLogin;
	
	public void init() {
		dbLogin = new DBLogin();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		try {
			if (dbLogin.validate(user)) {
				
				session.setAttribute("role", username);
				response.sendRedirect("premain.jsp");
				
				
				
			} else {
				session.setAttribute("err", "Неверные логин/пароль");
				response.sendRedirect("auth.jsp");
			}
			

		} catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("err", "Неверные логин/пароль");
			response.sendRedirect("auth.jsp");
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
