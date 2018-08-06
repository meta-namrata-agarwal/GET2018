package assignmentDS2ques3;

public class MainCircularQueue {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CircularQueue q = new CircularQueue(4);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(3);
        q.deQueue();
        System.out.println(q.deQueue());
        q.display();

        q.enqueue(6);
        q.display();
        System.out.println(q.deQueue());
    }

}
