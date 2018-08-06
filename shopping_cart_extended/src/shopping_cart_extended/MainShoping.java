package shopping_cart_extended;

public class MainShoping {

    public static void main(String[] args) {
        ShoppingCart cart=new ShoppingCart();
        cart.addItem(2, 5, 20);
        cart.display();
        cart.removeItemQuantity(2);
        cart.display();
        cart.removeItemQuantity(1);
        cart.display();
       cart.removeItem(1);
        cart.display();
       cart.generateBill("CODE2");
    }

}
