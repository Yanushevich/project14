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
		request.getRequestDispatcher("/results.jsp").forward(request, response);
	}

	private static class RequestCalc {
		private final double first_calc;
		private final double second_calc;
		private final int bank;
		private final int period;
		private final String radio;
		private double result;
						
		private RequestCalc (String Text1, String Text2, String bank, String period, String radio) {
			this.first_calc = Double.parseDouble(Text1);
			this.second_calc = Double.parseDouble(Text2);
			this.bank = Integer.parseInt(bank);
			this.period = Integer.parseInt(period);
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