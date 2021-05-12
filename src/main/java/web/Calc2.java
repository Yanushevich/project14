package web;

public class Calc2 extends Calculations {

	Calc2(String a, String b, String bank, String period) {
		super(a, b, bank, period);
	}

	public static double getResult() {
		switch (period) {
		case 0: 
			result = a / (1 + b * bank/100);
		break;
		case 1:
		case 3:
		case 6:
			result = a / Math.pow((1 + bank/period/100), period * b);
		break;
		case 12:
			result = a / Math.pow((1 + bank/100), b);
		}
		return result;
	}

	final String setType() {
		return "Стартовый капитал";
	}
}
