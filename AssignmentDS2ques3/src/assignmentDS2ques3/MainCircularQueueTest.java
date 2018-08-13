package assignmentDS2ques3;

import static org.junit.Assert.*;


import org.junit.Test;

public class MainCircularQueueTest {
    @Test
    public void enqueueTestPositive() {
        CircularQueue<Integer> object = new CircularQueue<>(4);
        for (int i = 0; i < 4; i++) {
            object.enqueue(i + 1);
        }
    }

    @Test(expected=AssertionError.class)
    public void enqueueTestNegative() {
        CircularQueue<Integer> object = new CircularQueue<>(4);
        for (int i = 0; i <= 4; i++) {
            object.enqueue(i + 1);
        }
    }

    @Test
    public void dequeueTestPositive() {
        CircularQueue<Integer> object = new CircularQueue<>(4);
        for (int i = 0; i < 4; i++) {
            object.enqueue(i + 1);
        }
        object.deQueue();
        assertSame(2, object.deQueue());
    }

    @Test  (expected = AssertionError.class)
    public void deQueueTestNegative() {
        CircularQueue<Integer> object = new CircularQueue<>(3);
        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }
        object.deQueue();
        object.deQueue();
        object.deQueue();
        object.deQueue();

    }

    @Test
    public void isFullTest() {
        CircularQueue<Integer> object = new CircularQueue<>(3);
        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }
        boolean checkFull = object.isFull();
        assertEquals(true, checkFull);
        object.deQueue();
        boolean checkFull1 = object.isFull();
        assertEquals(false, checkFull1);
    }

    @Test
    public void isEmptyTest() {

        CircularQueue<Integer> object = new CircularQueue<>(3);
        boolean checkFull = object.isEmpty();
        assertEquals(true, checkFull);
       
        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }

        boolean checkFull1 = object.isEmpty();
        assertEquals(false, checkFull1);
    }

    @Test 
    public void frontTest() {
        CircularQueue<Integer> object = new CircularQueue<>(3);

        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }
        assertSame(1, object.frontElement());
    }

}
