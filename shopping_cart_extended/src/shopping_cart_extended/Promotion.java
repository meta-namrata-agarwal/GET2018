package shopping_cart_extended;


public interface Promotion {

    public double getMinimumPrice();
    
    public void setMinimumPrice(double minimumPrice);
    
    public double getFixedDiscount();
    
    public void setFixedDiscount(double discount);
    
    public boolean isPromotionApplicable(String code);
}
