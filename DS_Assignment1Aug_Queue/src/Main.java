
public class Main {

    public static void main(String[] args) {
        QueueByArray<Integer> q = new QueueByArray<Integer>(5);
        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(4);
        q.deQueue();
        q.deQueue();
        q.deQueue();

        q.display();
        System.out.println(q.rearElement());

        QueueByLinkList<Integer> t = new QueueByLinkList<Integer>();
        t.enqueue(1);
        t.enqueue(2);
        t.enqueue(3);
        t.display();
        System.out.println(t.frontElement());
        System.out.println();
        t.deQueue();
        t.enqueue(7);
        System.out.println(t.frontElement());
        t.deQueue();
        t.deQueue();
        t.deQueue();
        t.display();

    }

}
