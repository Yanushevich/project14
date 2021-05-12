package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}

	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private final String bank;
		private final String period;
		private final String radio;
		private double result;
						
		private RequestCalc (String Text1, String Text2, String bank, String period, String radio) {
			this.first_calc = Text1;
			this.second_calc = Text2;
			this.bank = bank;
			this.period = period;
			this.radio = radio;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("Text1"),
			request.getParameter("Text2"),
			request.getParameter("bank"),
			request.getParameter("period"),
			request.getParameter("radio"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", first_calc);
			request.setAttribute("second_result", second_calc);
			request.setAttribute("bank", bank);
			request.setAttribute("period", period);
			
			double first_try;
			double second_try;
			try {
			first_try=Integer.parseInt(first_calc);
			second_try=Integer.parseInt(second_calc);
			}
			catch (NumberFormatException e) {
				first_try=0;
				second_try=0;	
			}
			
			switch (radio) {
			
				case "a": 
					result = Calc1.getResult();
					request.setAttribute("radio", "�����");
	
				case "b": 
					result = Calc2.getResult();
					request.setAttribute("radio", "��������� �������");
					
				case "c":
					result = Calc3.getResult();
					request.setAttribute("radio", "���� ���������� ����");
				}
			}
			
			
		}
		
}