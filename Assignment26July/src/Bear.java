public class Bear extends Mammal{

    private static int id = 1; 
    
    /**
     * This constructor initializes the Elephant properties and calls its super to add other properties
     * @param weight
     * @param age
     */
    public Bear(double weight, int age) {
        super("Bear" + (id++), weight, age, "xyz", 4, false, AnimalType.BEAR);
        
    }

}