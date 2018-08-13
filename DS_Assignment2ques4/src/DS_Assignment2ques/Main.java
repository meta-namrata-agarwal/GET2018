package DS_Assignment2ques;


public class Main {

    public static void main(String[] args) {

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
