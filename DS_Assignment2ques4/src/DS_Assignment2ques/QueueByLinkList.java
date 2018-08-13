package DS_Assignment2ques;

import java.util.NoSuchElementException;

/**
 * class to implement linked list operations using Queue of type T T is a
 * generic data type
 */
public class QueueByLinkList<T> implements QueueInterface<T> {
    /**
     * node class with data of type T and the next of node type
     */
    public class node {
        T data;
        node next;

        public node(T d) {
            data = d;
            next = null;
        }
    }

    node rear = null;
    node front = null;

    /**
     * enqueue function to add value to queue at rear
     * 
     * @param takes
     *            input data
     */
    @Override
    public void enqueue(T value) {
        node temp = new node(value);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    /**
     * deQueue function to remove the element from the queue from the front
     * 
     * @return removed element
     */

    @Override
    public T deQueue() {
        if (isEmpty())
            throw new NoSuchElementException();
        node temp = front;
        front = front.next;
        if (front == null)
            rear = null;
        return temp.data;
    }

    /**
     * rear function of generic type
     * 
     * @return data at rear
     */
    @Override
    public T rearElement() {
        return rear.data;
    }

    /**
     * front function of generic type
     * 
     * @return data at front
     */
    @Override
    public T frontElement() {
        return front.data;
    }

    /**
     * isFull method
     * 
     * @return false as linked list is dynamic
     */
    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * isEmpty method to check linked list is empty or not
     * 
     * @return boolean value
     */

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    /**
     * display method
     * 
     */

    @Override
    public void display() {

        node tempDisplay = front;
        while (tempDisplay != null) {
            System.out.print(tempDisplay.data + "\t");
            tempDisplay = tempDisplay.next;
        }

    }

}
