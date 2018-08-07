package assignmentDS2ques2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

    @Test
    public void postfixtest() {
       String expression="a+b-(ab+c*d)/g";
       String result=InfixToPostfix.postfix(expression);
       assertEquals("ab+abcd*+g/-", result);
      
    }
    @Test(expected=AssertionError.class)
    public void negativeTest()
    {
        String expression1="a+b-(ab+c*d/g";
        String result1=InfixToPostfix.postfix(expression1);
        assertEquals("ab+abcd*+g/-", result1);
    }

}
