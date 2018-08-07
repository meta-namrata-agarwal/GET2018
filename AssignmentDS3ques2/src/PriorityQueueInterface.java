
public interface PriorityQueueInterface<T> {

    void insert(T element, int priority);

    T remove();

    boolean isEmpty();

    boolean isFull();

    T frontElement();

}
