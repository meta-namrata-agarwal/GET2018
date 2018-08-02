import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationsTest {
	StringOperations so = new StringOperations();

	@Test
	public void isEqualPositive() {
		int check = so.isEqual("i am namrata", "i am namrata");
		assertEquals(1, check);
		int check1 = so.isEqual("i am NAmrata", "i am namrata");
		assertEquals(0, check1);
	}

	@Test
	public void isEqualNegative() {
		int check = so.isEqual("i am namrata", "i am namrata");
		assertEquals(0, check);
		int check1 = so.isEqual("i am NAmrata", "i am namrata");
		assertEquals(1, check1);
	}

	@Test
	public void reversePositive() {
		String check = so.reverseString("i am naMrAta");
		assertEquals("atArMan ma i", check);
	}

	@Test
	public void reverseNegative() {
		String check = so.reverseString("i am naMrAta");
		assertEquals("atArman ma i", check);
	}

	@Test
	public void togglePositive() {
		String check = so.toggleCase("hii namRATA");
		assertEquals("HII NAMrata", check);
	}

	@Test
	public void toggleNegative() {
		String check = so.toggleCase("hii namRATA");
		assertEquals("HII NAmrAta", check);
	}

	@Test
	public void LargetWordPositive() {
		String check = so.largestWord("hii namRATA");
		assertEquals("namRATA", check);
	}

	@Test
	public void LargetWordNegative() {
		String check = so.largestWord("hii namRATA");
		assertEquals("namRaTA", check);
	}

}
