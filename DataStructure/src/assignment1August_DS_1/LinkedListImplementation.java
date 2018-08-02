package assignment1August_DS_1;

import java.util.NoSuchElementException;

/**
 * class to implement linked list operations using stack of type T 
 * T is a generic data type
 */
public class LinkedListImplementation<T> implements Stack<T> {
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

    node top = null;

    /**
     * push function to add value to stack
     * 
     * @param takes
     *            input data
     */
    @Override
    public void push(T value) {
        node p = new node(value);
        p.next = top;
        top = p;
    }

    /**
     * pop function to remove the element from the stack
     * 
     * @return removed element
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("stack is empty");
        T hold = top.data;
        top = top.next;
        return hold;
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
        if (top == null)
            return true;
        else
            return false;
    }

    /**
     * display method
     * 
     */
    @Override
    public void display() {
        node tempDisplay = top;
        while (tempDisplay != null) {
            System.out.println(tempDisplay.data);
            tempDisplay = tempDisplay.next;
        }

    }

    /**
     * Top function of generic type
     * 
     * @return data at top
     */
    @Override
    public T top() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "no element pesent, cant return top value");
        return top.data;
    }

}
