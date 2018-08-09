public class Lion extends Mammal{

private static int id = 1; 
    
    /**
     * This initializes Lion and calls its super to add other properties
     * @param weight
     * @param age
     */
    public Lion(double weight, int age) {
        super("Lion" + (id++), weight, age, "Roar", 4, false, AnimalType.LION);
    }

}