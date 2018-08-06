package shopping_cart_extended;

public class Item 
{
    private int id;
    private int quantity;
    private double price;
    public Item(int id,int quantity,double price)
    {
        this.id=id;
        this.price=price;
        this.quantity=quantity;
    }
    public void setId(int val)
    {
        this.id=val;
    }
    public int getId()
    {
        return id;
    }
    public void setPrice(double val)
    {
        this.price=val;
    }
    public double getPrice()
    {
        return price;
    }
    public void setQuantity(int val)
    {
        this.quantity=val;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public double total()
    {
        return quantity*price;
    }
    public void displayList()
    {
        System.out.println(id+"\t    "+quantity+"\t\t"+price+"\t"+total());
    }
    
}
