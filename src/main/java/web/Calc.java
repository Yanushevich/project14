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
	public static  double first_calcGet;
	public static double second_calcGet;
	public static int bankGet;
	public static int periodGet;
	public static String radioGet;
	public static double resultGet;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/results.jsp").forward(request, response);
		
		CreatePDF PDF = new CreatePDF();
		String goals = "Hello";
		PDF.Create(goals);
	}

	private static class RequestCalc {
		private final double first_calc;
		private final double second_calc;
		private final int bank;
		private final int period;
		private final String radio;
		private double result;
						
		private RequestCalc (String Text1, String Text2, String bank1, String period1, String radio) {
		
			double first_try;
			double second_try;
			try { 
			first_try = Double.parseDouble(Text1);
			second_try = Double.parseDouble(Text2);
			}
			catch (NumberFormatException e) {
				first_try=0;
				second_try=0;	
			}
			this.first_calc = first_try;
			this.second_calc = second_try;
			this.bank = Integer.parseInt(bank1);
			this.period = Integer.parseInt(period1);
			this.radio = radio;
			
			
			first_calcGet=first_calc;
			second_calcGet=second_calc;
			bankGet=bank;
			periodGet=period;
		    radioGet=radio;
			resultGet=result;
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
			request.setAttribute("bank", bank);
			request.setAttribute("period", period);
			
			
			
			System.out.println(first_calc);			
			System.out.println(second_calc);
			System.out.println(bank);
			System.out.println(period);
			System.out.println(radio);
			
			switch (radio) {
			
				case "a":
					result = Calc1.getResult(first_calc, second_calc, bank, period);
					request.setAttribute("radio", "Доход");
					request.setAttribute("first_result", "Стартовый капитал: " + first_calc);
					request.setAttribute("second_result", "Срок инвестирования в годах: " + second_calc);
					break;
				case "b":
					result = Calc2.getResult(first_calc, second_calc, bank, period);
					request.setAttribute("radio", "Стартовый капитал");
					request.setAttribute("first_result", "Ваша цель: " + first_calc);
					request.setAttribute("second_result", "Срок инвестирования в годах: " + second_calc);
					break;
				case "c":
					result = Calc3.getResult(first_calc, second_calc, bank, period);
					request.setAttribute("radio", "Срок достижения цели");
					request.setAttribute("first_result", "Ваша цель: " + first_calc);
					request.setAttribute("second_result", "Стартовый капитал: " + second_calc);
					break;
				}
			
			request.setAttribute("result", result);
			}
			
			
			
		}
		
}