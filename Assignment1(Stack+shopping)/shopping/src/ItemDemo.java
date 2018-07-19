
import java.util.Scanner;

public class ItemDemo {

   public static void main(String args[]) {

       
       char choice;
       Shop aShop = new Shop();
       Scanner sc = new Scanner(System.in);
      
       System.out.println("-----ITEM------");
       do {
           System.out.println("1. Add items to cart");
           System.out.println("2. Update Quantity of Existing Item");
           System.out.println("3. Display bill");
           System.out.println("4. Check available items");
           System.out.println("5. Remove items from cart");
           System.out.println("6. Exit");
           System.out.println("Choice:");
           choice = sc.nextLine().charAt(0);
           switch (choice) {
           case '1':
               aShop.addItem();
               break;

           case '2':
               aShop.updateQuantity();
               break;

           case '3':
               aShop.displayBill();
               break;

           case '4':
        	   aShop.checkItems();
        	   	break;
           case '5':
        	   aShop.removeItem();
        	   	break;
           case '6':
               System.out.println("Thank you!\n");
               break;
           }
       } while (choice != '6');
       sc.close();
   }

 
}