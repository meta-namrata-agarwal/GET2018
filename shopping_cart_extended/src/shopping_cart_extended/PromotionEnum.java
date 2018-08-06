package shopping_cart_extended;
import java.util.GregorianCalendar;
public enum PromotionEnum 
{
    PROMO1("CODE1", new GregorianCalendar(2018,7,3), new GregorianCalendar(2018,8,8)),
    PROMO2("CODE2", new GregorianCalendar(2018,7,29), new GregorianCalendar(2018,8,10)),
    PROMO3("CODE3", new GregorianCalendar(2018,7,20), new GregorianCalendar(2018,8,3)),
    PROMO4("CODE4", new GregorianCalendar(2018,7,20), new GregorianCalendar(2018,8,3));   
    
    private String code;
    private GregorianCalendar endDate;
    private GregorianCalendar startDate;

    private PromotionEnum(String code, GregorianCalendar startDate, GregorianCalendar endDate )
    {
        this.code=code;
        this.startDate=startDate;
        this.endDate=endDate;       
    }
    
    public void setCode(String code)
    {
        this.code=code;
    }
    public String getCode()
    {
        return code;
    }
    public void setStartDate(GregorianCalendar startDate)
    {
        this.startDate=startDate;
    }
    public GregorianCalendar getStartDate()
    {
        return startDate;
    }
    
    public void setEndDate(GregorianCalendar endDate)
    {
        this.endDate=endDate;
    }
    public GregorianCalendar getEndDate()
    {
        return endDate;
    }
    
}


