package web;

import static org.junit.Assert.*;

import org.junit.Test;

public class Calc1Test {

	@Test
	public void test() {
		double calc = Calc1.getResult(1000, 5, 4, 12);
		assertNotNull(calc);
	}

}
