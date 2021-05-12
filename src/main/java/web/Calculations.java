package web;

	public abstract class Calculations {
		
		static double a;
		static double b;
		static int bank;
		static int period;
		static double result;

		Calculations (double a, double b, int bank, int period){
			
			this.a = a;
			this.b = b;
			this.bank = bank;
			this.period = period;
			
		}
		
		abstract String setType();
	}
