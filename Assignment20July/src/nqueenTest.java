import static org.junit.Assert.*;

import org.junit.Test;

public class nqueenTest {
	nqueen qu = new nqueen();

	@Test
	public void test() {
		boolean check = qu.solveNQ();
		assertEquals(true, check);
	}

}
