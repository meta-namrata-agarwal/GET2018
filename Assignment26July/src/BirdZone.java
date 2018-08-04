

/**
 * This class inherits the Zone class and used to add Bird Zone in the Zoo
 * @author Namrata
 * */
public class BirdZone extends Zone{

    /**
     * It initializes the BirdZone properties into Zoo
     * @param capacity
     */
    public BirdZone(int capacity)
    {
        super(AnimalCategory.BIRD, capacity);
    }
    
}
