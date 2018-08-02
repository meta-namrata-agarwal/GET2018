import static org.junit.Assert.*;

import org.junit.Test;

public class HexCalcTest {
	HexCalc hc = new HexCalc();

	@Test
	public void addTestPositive() {

		String deci = hc.add("25", "12", 16);
		assertEquals("37", deci);
	}
	@Test
	public void addTestNegative() {

		String deci = hc.add("25", "12", 16);
		assertEquals("7", deci);
	}

	@Test
	public void subtractTestPositive() {

		String deci = hc.subtract("25", "12", 16);
		assertEquals("13", deci);
	}
	@Test
	public void subtractTestNegative() {

		String deci = hc.subtract("25", "12", 16);
		assertEquals("103", deci);
	}
	@Test
	public void multiplyTestPositive() {

		String deci = hc.multiplication("25", "12", 16);
		assertEquals("29A", deci);
	}
	@Test
	public void multiplyTestNegative() {

		String deci = hc.multiplication("25", "12", 16);
		assertEquals("9A", deci);
	}
	@Test
	public void divisionTestPositive() {

		String deci = hc.division("25", "12", 16);
		assertEquals("2", deci);
	}
	@Test
	public void divisionTestNegative() {

		String deci = hc.division("3", "12", 16);
		assertEquals("2", deci);
	}

	@Test
	public void isGreaterPositive() {

		boolean deci = hc.isGreater("25", "12");
		assertEquals(true, deci);
	}

	@Test
	public void isGreaterNegative() {

		boolean deci = hc.isGreater("5", "12");
		assertEquals(true, deci);
	}

	@Test
	public void isLessPositive() {

		boolean deci = hc.isLess("25", "12");
		assertEquals(false, deci);
	}
	@Test
	public void isLessNegative() {

		boolean deci = hc.isLess("25", "125");
		assertEquals(false, deci);
	}
	@Test
	public void isEqualPositive() {

		boolean deci = hc.equal("25", "12");
		assertEquals(false, deci);
	}
	@Test
	public void isEqualNegative() {

		boolean deci = hc.equal("2", "12");
		assertEquals(true, deci);
	}
}
