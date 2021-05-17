package web;

import static org.junit.Assert.*;

import org.junit.AfterClass;

public class CalcTest {

	@AfterClass
	public void bankGetTest() {
		
		assertEquals (Calc.bankGet, "");
		
	}

}
