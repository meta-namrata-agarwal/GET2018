/**
 * 
 * @author Namrata Agarwal
 *
 * @param <T>
 */
public class ArrayQueue<T> {
    T element;
    int priority;
    public ArrayQueue(T element, int priority) {
      this.element=element;
      this.priority=priority;
    }
}