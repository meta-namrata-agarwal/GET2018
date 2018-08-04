
public class Crocodile extends Reptile{

    static int id = 1; 
    
    /**
     * It initializes the crocodile properties and calls its super to add other properties
     * @param weight
     * @param age
     */
    public Crocodile(double weight, int age) {
        
        super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalType.CROCODILE);
    }

}