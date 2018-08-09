package shopping_cart_extended;

public class FixedProduct implements Promotion {

    @Override
    public double getMinimumPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMinimumPrice(double minimumPrice) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getFixedDiscount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setFixedDiscount(double discount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isPromotionApplicable(String code) {
        // TODO Auto-generated method stub
        return false;
    }
    

}
