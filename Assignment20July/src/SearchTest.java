import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	@Test
	public void testPositiveLinear() {
		Search sch = new Search();
		int[] array = { 1, 2, 3, 4, 5 };
		int index = sch.searchElementByLinear(array, 0, 4, 3);
		assertEquals(2, index);
	}

	@Test
	public void testNegativeLinear() {
		Search sch = new Search();
		int[] array = {};
		int index = sch.searchElementByLinear(array, 0, 4, 3);
		assertEquals(1, index);
	}

	@Test
	public void testPositiveBinary() {
		Search sch = new Search();
		int[] array = { 1, 2, 3, 4, 5 };
		int index = sch.searchElementByBinary(array, 0, 4, 3);
		assertEquals(2, index);
	}

	@Test
	public void testNegativeBinary() {
		Search sch = new Search();
		int[] array = {};
		int index = sch.searchElementByBinary(array, 0, 4, 3);
		assertEquals(1, index);
	}

}
