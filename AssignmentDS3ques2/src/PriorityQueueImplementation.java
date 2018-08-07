
import java.util.NoSuchElementException;

/**
 * PriorityQueueImplementation class to implement the functions 
 * T is a Generic  type data
 * 
 * @author Namrata Agarwal
 *
 * @param <T>
 */
public class PriorityQueueImplementation<T> implements PriorityQueueInterface<T> {

    private int size;
    private int rear = -1;
    private ArrayQueue<T>[] QueueArray;

    @SuppressWarnings("unchecked")
    public PriorityQueueImplementation(int size) {
        this.size = size;
        QueueArray = (ArrayQueue<T>[]) new ArrayQueue[size];
    }

    /**
     * method to insert element in queue
     * 
     * @param element
     *            of generic type and priority
     */
    @Override
    public void insert(T element, int priority) {
        if (isFull())
            throw new StackOverflowError("QUEUE IS FULL");
        ArrayQueue<T> array = new ArrayQueue<>(element, priority);

        if (isEmpty()) {
            QueueArray[++rear] = array;
        } else {
            rear++;
            check(array);
        }
    }

    /**
     * method to check the priority of elements
     * 
     * @param array
     */
    private void check(ArrayQueue<T> array) {
        int i, j;
        for (i = 0; i < rear; i++) {
            if (array.priority > QueueArray[i].priority) {
                for (j = rear; j > i; j--) {
                    QueueArray[j] = QueueArray[j - 1];

                }
                QueueArray[i] = array;
                return;
            }
        }
        QueueArray[i] = array;
    }

    /**
     * remove method to remove element with highest priority
     * 
     * @return removed element of generic type
     */
    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException("empty queue");
        for (int i = 1; i <= rear; i++) {
            QueueArray[i - 1] = QueueArray[i];
        }
        rear--;
        return QueueArray[0].element;
    }

    /**
     * method checks whether queue is full or not
     * 
     * @return boolean value
     */
    @Override
    public boolean isFull() {
        return rear == size - 1;
    }

    /**
     * @return boolean value for the empty queue
     */
    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    /**
     * @return element at front
     */
    @Override
    public T frontElement() {
        return QueueArray[0].element;
    }

    /**
     * function to display queue elements
     */
    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.println(QueueArray[i].element);
        }
    }
}
