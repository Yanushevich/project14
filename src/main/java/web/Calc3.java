package web;

public class Calc3 extends Calculations {

	Calc3(String a, String b, String bank, String period) {
		super(a, b, bank, period);
	}

	public static double getResult() {
		switch (period) {
		case 0: 
			result = (a / b - 1) * 100 / bank;
		break;
		case 1:
		case 3:
		case 6:
			result = Math.log(a / b) / Math.log(1 + bank / period / 100) / period;
		break;
		case 12:
			result = Math.log(a / b) / Math.log(1 + bank / 100);
		}
		return result;
	}

	final String setType() {
		return "Срок достижения цели";
	}
}