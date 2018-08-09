
public class Peacock extends Bird{

    static int id = 1; 
    
    /**
     * It initializes the peacock properties and calls its super to add other properties
     * @param weight
     * @param age
     * @param wingsSpan
     */
    public Peacock(double weight, int age, double wingsSpan) {
        
        super("Peacock" + (id++), weight, age, "scream", 2, true, wingsSpan, AnimalType.PEACOCK);
    }

}