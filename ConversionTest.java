import static org.junit.Assert.*;

import org.junit.Test;

public class ConversionTest {
	Conversion con = new Conversion();

	@Test
	public void baseXtoDeciTestPositive() {

	    int deci = con.baseXtoDeci("25", 16);
		assertEquals(37, deci);
	}

	@Test
	public void deciToBaseXtestPositive() {

		String deci = con.deciToBaseX(37, 16);
		assertEquals("25", deci);
	}

	@Test
	public void baseXtoDeciTestNegative() {

		int deci = con.baseXtoDeci("25", 16);
		assertEquals(7, deci);
	}

	@Test
	public void deciToBaseXtestNegative() {

		String deci = con.deciToBaseX(37, 16);
		assertEquals("257", deci);
	}

}
