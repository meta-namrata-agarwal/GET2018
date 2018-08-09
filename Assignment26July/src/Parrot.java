
public class Parrot extends Bird{

    static int id = 1; 
    
    /**
     * It initializes the parrot properties and calls its super to add other properties
     * @param weight
     * @param age
     * @param wingsSpan
     */
    public Parrot(double weight, int age, double wingsSpan) {
        
        super("Parrot" + (id++), weight, age, "squawk", 2, true, wingsSpan, AnimalType.PARROT);
    }

}