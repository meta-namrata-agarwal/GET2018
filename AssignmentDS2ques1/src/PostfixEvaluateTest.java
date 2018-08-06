import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluateTest {

    @Test(expected = AssertionError.class)
    public void evaluateTest() {
        PostfixEvaluate postfix = new PostfixEvaluate();
        postfix.evaluate("8 3 5 8 * - +");
        assertEquals(-29, postfix.evaluate("8 3 5 8 * - +"), 2);

        assertEquals(67, postfix.evaluate("8 * 4 2 +"), 1);
    }

}
