package assignment1August_DS_1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayImplementationTest {

    @Test
    public void pushTestPositive() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(4);
        for (int i = 0; i < 4; i++) {
            stackObject.push(i + 1);
        }
    }

    @Test(expected = AssertionError.class)
    public void pushTestNegative() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(4);
        for (int i = 0; i < 5; i++) {
            stackObject.push(i + 1);
        }
    }

    @Test
    public void popTestPositive() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(4);
        for (int i = 0; i < 4; i++) {
            stackObject.push(i + 1);
        }
        stackObject.pop();
        assertSame(3, stackObject.pop());
    }

    @Test(expected = NoSuchElementException.class)
    public void popTestNegative() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(3);
        for (int i = 0; i < 3; i++) {
            stackObject.push(i + 1);
        }
        stackObject.pop();
        stackObject.pop();
        stackObject.pop();
        stackObject.pop();
    }

    @Test
    public void isFullTest() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(3);
        for (int i = 0; i < 3; i++) {
            stackObject.push(i + 1);
        }
        boolean checkFull = stackObject.isFull();
        assertEquals(true, checkFull);
        stackObject.pop();
        boolean checkFull1 = stackObject.isFull();
        assertEquals(false, checkFull1);
    }

    @Test
    public void isEmptyTest() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(3);
        boolean checkFull = stackObject.isEmpty();
        assertEquals(true, checkFull);

        for (int i = 0; i < 3; i++) {
            stackObject.push(i + 1);
        }

        boolean checkFull1 = stackObject.isEmpty();
        assertEquals(false, checkFull1);
    }

    @Test(expected = AssertionError.class)
    public void topTest() {
        Stack<Integer> stackObject = new ArrayImplementation<Integer>(3);
        assertSame(3, stackObject.top());

        for (int i = 0; i < 3; i++) {
            stackObject.push(i + 1);
        }
        assertSame(3, stackObject.top());
    }

}
