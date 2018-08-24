
package dbms;

public class Category {

    private String name;
    private int countCategory;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the countCategory
     */
    public int getCountCategory() {
        return countCategory;
    }

    /**
     * @param countCategory
     *            the countCategory to set
     */
    public void setCountCategory(int countCategory) {
        this.countCategory = countCategory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Category [Top Category=" + getName() + ", CountCategory=" + getCountCategory() + "]";
    }

}
