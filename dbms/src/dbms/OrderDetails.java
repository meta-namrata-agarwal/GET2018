package dbms;

import java.util.Date;

public class OrderDetails {
    private float price;
    private int orderId;
    private Date date;

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrderDetails [Price=" + getPrice() + ", OrderId="
                + getOrderId() + ", Date=" + getDate() + "]";
    }

    
    
    
    

}
