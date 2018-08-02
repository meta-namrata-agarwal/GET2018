package assignment1August_DS_1;

public class MainClassStack {

    public static void main(String[] args) {
        ArrayImplementation<Integer> newStack = new ArrayImplementation<Integer>(5);
        newStack.push(10);
        newStack.push(1);
        newStack.push(50);
        newStack.push(20);
        newStack.push(90);

        newStack.display();
        newStack.pop();
        newStack.pop();
        newStack.display();
        System.out.println(newStack.top());
        
        LinkedListImplementation<Integer> newLink = new LinkedListImplementation<Integer>();
        newLink.push(10);
        newLink.push(1);
        newLink.push(23);
       
        System.out.println(newLink.top());
        newLink.display();
        

    }

}
