package shopping_cart_extended;

import java.util.Date;
import java.util.GregorianCalendar;

public class FixedOrder implements Promotion {

    private double minimumPrice;
    private double discount;
    //private boolean result;

    @Override
    public double getMinimumPrice() {

        return minimumPrice;
    }

    @Override
    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;

    }

    @Override
    public double getFixedDiscount() {

        return discount;
    }

    @Override
    public void setFixedDiscount(double discount) {
        this.discount = discount;

    }

    @Override
    public boolean isPromotionApplicable(String code) {
        Date currentDate = new Date();
        
        boolean result = false;
        
        for(PromotionEnum promotion: PromotionEnum.values())
        {
            if(code.equals(promotion.getCode()))
            {                   System.out.println(" applied:"+discount+" %");
                
                if(currentDate.after(promotion.getStartDate().getTime()) && currentDate.before(promotion.getEndDate().getTime())) {
                    result = true;
                    System.out.println(result);
                }
            }
        }return true;
        
    }
}
