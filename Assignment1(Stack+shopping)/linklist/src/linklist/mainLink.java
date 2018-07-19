
package linklist;
import java.util.*;
public class mainLink {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IMPLEMENT stack1 = new IMPLEMENT();
        while (true) {
            System.out.println("\nStack MENU");
            System.out.println("1. Add element");
            System.out.println("2. See  Top element.");
            System.out.println("3. Remove top element.");
            System.out.println("4. Display stack elements.");
            System.out.println("5. Exit");
            System.out.println("Select choice: ");
            int choice = in.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter Element : ");
                stack1.push(in.nextInt());
                break;
 
            case 2:
                System.out.printf("Top element is: %d", stack1.topv());
                break;
 
            case 3:
                System.out.printf("Element removed: %d", stack1.pop());
                break;
 
            case 4:
                stack1.display();
                break;
 
            case 5:
            default:
                System.exit(0);
                break;
            }
            System.out.printf("\n");
            in.close();  
        }
       
    }

}
