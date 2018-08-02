import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionLcmHcfTest {

	@Test
	public void testPositiveLcm() {
		RecursionLcmHcf rl = new RecursionLcmHcf();
		int lcm = rl.findLcm(12, 14);
		assertEquals(lcm, 84);
	}

	@Test
	public void testNegativeLcm() {
		RecursionLcmHcf rl = new RecursionLcmHcf();
		int lcm = rl.findLcm(12, 14);
		assertEquals(lcm, 4);
	}

	@Test
	public void testPositiveHcf() {
		RecursionLcmHcf rl = new RecursionLcmHcf();
		int lcm = rl.findHcf(12, 14);
		assertEquals(lcm, 2);
	}

	@Test
	public void testNegativeHcf() {
		RecursionLcmHcf rl = new RecursionLcmHcf();
		int lcm = rl.findHcf(12, 14);
		assertEquals(lcm, 12);
	}
}
