package assignment1August_DS_1;

public interface Stack<T> {
    public void push(T value);

    public T pop();

    public boolean isFull();

    public boolean isEmpty();

    public void display();
    
    public T top();
}
