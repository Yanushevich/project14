package web;

	public abstract class Calculations {
		
		static double a;
		static double b;
		static int bank;
		static int period;
		static double result;

		Calculations (String a, String b, String bank, String period){
			
			this.a = Double.parseDouble(a);
			this.b = Double.parseDouble(b);
			this.bank = Integer.parseInt(bank);
			this.period = Integer.parseInt(period);
			
		}
		
		abstract String setType();
	}
