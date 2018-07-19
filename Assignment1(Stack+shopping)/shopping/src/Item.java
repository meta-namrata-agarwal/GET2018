


public class Item {
    private String name;
    private int rate;
    private int code;
    private int quantity;
 

    public Item(String name, int rate, int code) {
        this.name = name;
        this.rate = rate;
        this.code = code;
     
    }

    public void display() {
        System.out.println(""+code+"\t" +name + "\t"+ rate + "\t" +  quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }
    public int getCode() {
        return code;
    }
  
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
