package assignmentDS2ques3;

/**
 * class to implement the circular queue operations
 * 
 * @author Namrata Agarwal
 *
 * @param <T>
 */
public class CircularQueue<T> {
    private int size;
    T[] Queue;
    private int rear = -1;
    int front = -1;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        this.size = size;
        Queue = (T[]) new Object[size];
    }

    /**
     * insert element into the queue
     * 
     * @param value
     */
    public void enqueue(T value) {
        if (isFull())
            throw new AssertionError("queue is full");
        if (front == -1) {
            rear = front = 0;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;

        } else
            rear = (rear + 1) % size;
        Queue[rear] = value;
    }

    /**
     * remove element from the queue from front end
     * 
     * @return removed element
     */
    public T deQueue() {
        if (isEmpty())
            throw new AssertionError("queue is empty");
        T removeData = Queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;

        } else if (front == size - 1)
            front = 0;
        else
            front += 1;
        return removeData;
    }

    /**
     * checks if the queue is full
     * 
     * @return boolean value
     */
    public boolean isFull() {

        return (rear + 1) % size == front;
    }

    /**
     * checks if the queue is empty or not
     * 
     * @return boolean value
     */
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    /**
     * display mehtod
     */
    public void display() {

        if (front == -1)
            throw new AssertionError("queue is empty");
        else {
            int i = front;

            if (front <= rear) {
                while (i <= rear)
                    System.out.println(Queue[i++]);
            } else {
                while (i <= size - 1)
                    System.out.println(Queue[i++]);
                i = 0;
                while (i <= rear)
                    System.out.println(Queue[i++]);
            }
        }

    }

    public T frontElement() {
       
        return Queue[front];
    }

}
