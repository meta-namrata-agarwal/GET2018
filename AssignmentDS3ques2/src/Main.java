public class Main {

    public static void main(String[] args) {
        PriorityQueueImplementation<Integer> queue = new PriorityQueueImplementation<Integer>(4);
        queue.insert(4, 1);
        queue.insert(7, 30);
        queue.insert(1, 10);
        queue.insert(8, 12);
        //System.out.println(queue.frontElement());
        queue.display();
        queue.remove();
        System.out.println();
        queue.display();
        System.out.println(queue.frontElement());
        System.out.println(queue.isFull());
    }

}