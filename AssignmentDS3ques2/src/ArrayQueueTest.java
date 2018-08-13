package ds_Assignment3July_ques2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {
    PriorityQueueImplementation<Integer> checkQueue = new PriorityQueueImplementation<Integer>(3);

    @BeforeEach
    public void ArrayQueueObject() {
        checkQueue.insert(3, 10);
        checkQueue.insert(7, 1);
        checkQueue.insert(12, 20);
    }

    @Test
    public void insertTest() {
        Assertions.assertThrows(StackOverflowError.class, ()->checkQueue.insert(6, 122));

    }

    @Test
    public void removeTest() {
        checkQueue.remove();
        checkQueue.remove();
        checkQueue.remove();
        Assertions.assertThrows(NoSuchElementException.class, ()-> checkQueue.remove());
        
    }

    @Test
    public void isFullTest() {
        boolean checkFull = checkQueue.isFull();
        assertEquals(true, checkFull);
        checkQueue.remove();
        boolean checkFull1 = checkQueue.isFull();
        assertEquals(false, checkFull1);
    }

    @Test
    public void isEmptyTest() {
        boolean checkFull = checkQueue.isEmpty();
        assertEquals(false, checkFull);
        checkQueue.remove();
        checkQueue.remove();
        checkQueue.remove();

        boolean checkFull1 = checkQueue.isEmpty();
        assertEquals(true, checkFull1);
    }

    @Test 
    public void frontTest() {
        assertSame(12, checkQueue.frontElement());
    }

}