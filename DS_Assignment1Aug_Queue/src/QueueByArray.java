/**
    * class to implement array operations using queue of type T 
    * T is a generic data type
    */
public class QueueByArray<T> implements QueueInterface<T> {
    private int size;
    T[] Queue;
    private int rear = -1;
    final int front = 0;

    @SuppressWarnings("unchecked")
    public QueueByArray(int size) {
        this.size = size;
        Queue = (T[]) new Object[size];
    }
    /**
     * enqueue function to add value to queue at rear end
     * 
     * @param takes
     *            input data
     */
    @Override
    public void enqueue(T value) {
        if (isFull())
            throw new AssertionError("queue is full");
        Queue[++rear] = value;
    }
    /**
     * deQueue function to remove the element from the queue from front end
     * 
     * @return removed element
     */
    @Override
    public T deQueue() {
        if (isEmpty())
            throw new AssertionError("queue is empty");
        T removeData = Queue[0];
        for (int i = 0; i < rear - 1; i++) {
            Queue[i] = Queue[i + 1];
        }
        rear--;
        return removeData;
    }
    /**
     * isFull method
     * 
     * @return boolean value
     */
    @Override
    public boolean isFull() {
        if (rear+1 == size)
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
        if (rear == -1)
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

        for (int i = 0; i < rear; i++) {
            System.out.println(Queue[i]);
        }

    }

    /**
     * rear function of generic type
     * 
     * @return data at rear
     */
    @Override
    public T rearElement() {
        // TODO Auto-generated method stub
        return Queue[rear-1];
    }

    /**
     * front function of generic type
     * 
     * @return data at front
     */
    @Override
    public T frontElement() {
        // TODO Auto-generated method stub
        return Queue[front];
    }

}
