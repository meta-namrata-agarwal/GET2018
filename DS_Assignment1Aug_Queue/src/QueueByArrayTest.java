import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

class QueueByArrayTest {

    @Test
    public void enqueueTestPositive() {
        QueueInterface<Integer> object = new QueueByArray<>(4);
        for (int i = 0; i < 4; i++) {
            object.enqueue(i + 1);
        }
    }

    @Test
    public void enqueueTestNegative() {
        QueueInterface<Integer> object = new QueueByArray<>(4);
        for (int i = 0; i <= 4; i++) {
            object.enqueue(i + 1);
        }
    }

    @Test
    public void dequeueTestPositive() {
        QueueInterface<Integer> object = new QueueByArray<>(4);
        for (int i = 0; i < 4; i++) {
            object.enqueue(i + 1);
        }
        object.deQueue();
        assertSame(2, object.deQueue());
    }

    @Test  (expected = NoSuchElementException.class)
    public void deQueueTestNegative() {
        QueueInterface<Integer> object = new QueueByArray<>(3);
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
        QueueInterface<Integer> object = new QueueByArray<>(3);
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

        QueueInterface<Integer> object = new QueueByArray<>(3);
        boolean checkFull = object.isEmpty();
        assertEquals(true, checkFull);
       
        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }

        boolean checkFull1 = object.isEmpty();
        assertEquals(false, checkFull1);
    }

    @Test (expected = AssertionError.class)
    public void frontTest() {
        QueueInterface<Integer> object = new QueueByArray<>(3);
        assertSame(3, object.frontElement());

        for (int i = 0; i < 3; i++) {
            object.enqueue(i + 1);
        }
        assertSame(1, object.frontElement());
    }

}
