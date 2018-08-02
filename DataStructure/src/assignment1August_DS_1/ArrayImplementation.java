package assignment1August_DS_1;

import java.util.NoSuchElementException;
/**
* class to implement array operations using stack of type T 
* T is a generic data type
*/
public class ArrayImplementation<T> implements Stack<T> {
    int top = -1;
    int size;
    T[] stack;

    @SuppressWarnings("unchecked")
    public ArrayImplementation(int arraySize) {
        size = arraySize;
        stack = (T[]) new Object[size];
    }
    /**
     * push function to add value to stack
     * 
     * @param takes
     *            input data
     */
    @Override
    public void push(T value) {
        if (isFull())
            throw new AssertionError("stack full");
        else
            stack[++top] = value;
    }
    /**
     * pop function to remove the element from the stack
     * 
     * @return removed element
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        } else {
            return stack[top--];
        }
    }
    /**
     * isFull method
     * 
     * @return boolean value
     */
    @Override
    public boolean isFull() {
        if (top == size - 1)
            return true;
        else
            return false;
    }
    /**
     * isEmpty method to check array is empty or not
     * 
     * @return boolean value
     */
    @Override
    public boolean isEmpty() {
        if (top == -1)
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
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    /**
     * Top function of generic type
     * 
     * @return data at top
     */
    @Override
    public T top() {
        if (isEmpty())
            throw new AssertionError("stack empty");
        return stack[top];
    }
}
