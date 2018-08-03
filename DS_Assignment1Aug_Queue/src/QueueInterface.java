
public interface QueueInterface<T> {

    public void enqueue(T value);

    public T deQueue();

    public boolean isFull();

    public boolean isEmpty();

    public void display();

    public T rearElement();

    public T frontElement();

}
