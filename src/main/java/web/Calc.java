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
	public static String first_calcGet;
	public static String second_calcGet;
	public static String first_calcGet1;
	public static String second_calcGet1;
	public static String bankGet;
	public static String periodGet;
	public static String resultGet;
	public static String radioGet;
	public static String period1;
	public static String period2;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/results.jsp").forward(request, response);
		/*
		CreatePDF PDF = new CreatePDF();
		String goals = "Hello";
		PDF.Create(goals); 
		*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private static class RequestCalc {
		private final double first_calc;
		private final double second_calc;
		private final double bank;
		private final int period;
		private String radio;
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
			this.bank = Double.parseDouble(bank1);
			this.period = Integer.parseInt(period1);
			this.radio = radio;
			
			
			
			bankGet=""+bank;
			periodGet=""+period;
			
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
			
			switch (period) {
			
			case 0:
				period1 = "Не реинвестировать";
				period2 = "Do not reinvest";
				break;
			case 12:
				period1 = "1 раз в месяц";
				period2 = "Once a month";
				break;
			case 3:
				period1 = "1 раз в квартал";
				period2 = "Once a quarter";
				break;
			case 2:
				period1 = "1 раз в полгода";
				period2 = "Half-yearly";
				break;
			case 1:
				period1 = "1 раз в год";
				period2 = "Once a year";
				break;
				
				
			}
			
			request.setAttribute("period", period1);
			
			
			
			System.out.println(first_calc);			
			System.out.println(second_calc);
			System.out.println(bank);
			System.out.println(period);
			System.out.println(radio);
			
			switch (radio) {
			
				case "a":
					result = Calc1.getResult(first_calc, second_calc, bank, period);
					radio = "Доход";
					
					first_calcGet = "Стартовый капитал: " + first_calc;
					second_calcGet = "Срок инвестирования (в годах): " + second_calc;
					
					first_calcGet1 = "Startup capital: " + first_calc;
					second_calcGet1 = "Investment term (in years): " + second_calc;

					break;
				case "b":
					result = Calc2.getResult(first_calc, second_calc, bank, period);
					radio = "Стартовый капитал";
					
					first_calcGet = "Ваша цель: " + first_calc;
					second_calcGet = "Срок инвестирования (в годах): " + second_calc;	
					
					first_calcGet1 = "Your goal: " + first_calc;
					second_calcGet1 = "Investment term (in years): " + second_calc;
					
					break;
				case "c":
					result = Calc3.getResult(first_calc, second_calc, bank, period);
					radio = "Срок достижения цели";
					
					first_calcGet = "Ваша цель: " + first_calc;
					second_calcGet = "Стартовый капитал: " + second_calc;
					
					first_calcGet1 = "Your goal: " + first_calc;
					second_calcGet1 = "Startup capital: " + second_calc;
					
					break;
				}
			
			request.setAttribute("radio", radio);
			request.setAttribute("first_result", first_calcGet);
			request.setAttribute("second_result", second_calcGet);
			request.setAttribute("result", result);
			radioGet = "" + radio;
			resultGet = "" + result;
			}
			
			
			
		}
		
}