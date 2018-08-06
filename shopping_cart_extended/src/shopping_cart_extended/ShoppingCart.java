package shopping_cart_extended;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    List<Item> itemList = new ArrayList<Item>();
    private Promotion promotion;

    public ShoppingCart() {
        Item i = new Item(1, 0, 20);
        itemList.add(i);
        Item i1 = new Item(2,3 , 10);
        itemList.add(i1);
        Item i2 = new Item(3, 2, 5);
        itemList.add(i2);
    }

    public void addItem(int id, int quantity, double price) {
        int update = 0;
        for (Item item : itemList) {
            if (item.getId() == id) {
                update = 1;
                int q = item.getQuantity();
                item.setQuantity(quantity + q);
                item.setPrice(price);
                break;
            }
        }
        if (update == 0) {
            Item i = new Item(id, quantity, price);
            itemList.add(i);
        }

    }

    public void removeItemQuantity(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                int q = item.getQuantity();
                Scanner sc = new Scanner(System.in);
                if(q<1)
                {
                    System.out.println("operation not possible for id- " + id);
                }
                else
                {
                System.out.println("enter quantity to remove for id- " + id);
                System.out.println("avalible quantity is- " + q);
                int quantity1 = sc.nextInt();
                item.setQuantity(q - quantity1);
                }
            }

        }
    }

    public void removeItem(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                itemList.remove(item);
                break;
            }
        }
    }

    public void display() {
        System.out.println("ID\t" + "QUANTITY\t" + "PRICE\t"+"TOTAL\t");
        System.out.println("-------------------------------------");

        for (Item item : itemList) {
            item.displayList();
        }
    }
    
    public void generateBill(String promoCode)
    {
        double sum=0;
        System.out.println("Product id\t\tprice\t\tquantity\ttotal");
        for(Item item:itemList)
        {
            item.displayList();;
            sum += item.total();
        }
        
        promotion = new FixedOrder();
        promotion.setMinimumPrice(20);
        promotion.setFixedDiscount(10);
        double discount = applyPromotion(promotion, promoCode, sum);
        System.out.println("\nTotal:" + sum);
        System.out.println("discount applied:"+discount+" %");
        sum = sum - ((discount/100)*sum);
        System.out.println("Grand Total:  " + sum);
    }
    
    public double applyPromotion(Promotion promotion, String code, double amount)
    {
        double discount = 0;
        if(promotion.isPromotionApplicable(code) && amount >= promotion.getMinimumPrice())
        {
            discount = promotion.getFixedDiscount();
        }
        return discount;
    }
    
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

}
