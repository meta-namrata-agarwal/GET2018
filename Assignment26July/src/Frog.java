
public class Frog extends Reptile{

    static int id = 1; 
    
    /**
     * It initializes the snake properties and calls its super to add other properties
     * @param weight
     * @param age
     */
    public Frog(double weight, int age) {
        
        super("Frog" + (id++), weight, age, "quack", 0, true, "cold", AnimalType.FROG);
    }

}