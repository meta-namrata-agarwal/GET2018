
public class Reptile extends Animal{
    
    private final boolean isPoisonous;
    private final String bloodType;
    
    /**
     * The constructor initializes the Reptiles in the Zoo
     * It calls its super class constructor to initialize the basic animal properties 
     * @param name
     * @param weight
     * @param age
     * @param sound
     * @param numberOfLegs
     * @param isPoisonous
     * @param bloodType
     * @param animlType
     */
    public Reptile(String name, double weight, int age, String sound,
            int numberOfLegs, boolean isPoisonous, String bloodType, AnimalType animlType) {
        
        super(name, weight, age, sound, numberOfLegs, AnimalCategory.REPTILE, animlType);
        
        this.isPoisonous = isPoisonous;
        this.bloodType = bloodType;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public String getBloodType() {
        return bloodType;
    }
    
    
}