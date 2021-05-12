package web;

public class Calc2 extends Calculations {

	Calc2(double a, double b, int bank, int period)  {
		super(a, b, bank, period);
	}

	public static double getResult(double a, double b, int bank, int period) {
		
		switch (period) {
		case 0: 
			result = a / (1 + b * bank/100.0);
		break;
		case 12:
		case 3:
		case 2:
		case 1:
			result = a / Math.pow(1 + bank/100.0/period, period * b);
		break;
		}

		return result;
	}

	final String setType() {
		return "��������� �������";
	}
}
