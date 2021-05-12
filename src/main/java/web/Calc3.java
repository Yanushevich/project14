package web;

public class Calc3 extends Calculations {

	Calc3(double a, double b, int bank, int period)  {
		super(a, b, bank, period);
	}

	public static double getResult(double a, double b, int bank, int period) {
		switch (period) {
		case 0: 
			result = (a / b - 1) * 100 / bank;
		break;
		case 12:
		case 3:
		case 2:
			result = Math.log(a / b) / Math.log(1 + bank / 100.0 / period) / period;
		break;
		case 1:
			result = Math.log(a / b) / Math.log(1 + bank / 100.0);
		break;
		}
		return result;
	}

	final String setType() {
		return "Срок достижения цели";
	}
}