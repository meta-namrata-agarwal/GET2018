import java.util.ArrayList;
import java.util.List;

/**
 * This is the superclass for all the zones. This class provides the operations for the zone.
 * @author Namrata
 */
public class Zone 
{
    private AnimalCategory zoneType; 
    private final int capacity;
    private List<Cage> listOfCages = new ArrayList<>();
    
    /**
     * This Zone constructor initializes the zone properties
     * @param zoneType
     * @param capacity
     * Here getter setter are present to access properties
     */
    public Zone(AnimalCategory zoneType, int capacity)
    {
        this.zoneType = zoneType;
        this.capacity = capacity;
        
    }

    public AnimalCategory getZoneType() {
        return zoneType;
    }

    public void setZoneType(AnimalCategory zoneType) {
        this.zoneType = zoneType;
    }

    public List<Cage> getNoOfCages() {
        return listOfCages;
    }

   
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * this methods calculates the available capacity of the zone
     * @return the spare capacity
     */
    public int spareCapacity() {
        return capacity - listOfCages.size();
    }
    
    
    /**
     * This method adds the given cage to the zone
     * @param cage
     */
    public void addCage(Cage cage)
    {
        if(spareCapacity() != 0)
            listOfCages.add(cage);
        else
            throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
    }
    
    
    /**
     * This method will add animal to a specific cage
     * @param animal
     * @return true if animal added successfully, throws AssertionError otherwise
     */
    public boolean addAnimal(Animal animal)
    {
        boolean flag = false;
        
        for(Cage cage: listOfCages)
        {
            if(cage.getAnimalType().equals(animal.getAnimalType()) && cage.spareCapacity() != 0)
            {
                flag = true;
                cage.addAnimal(animal);
                break;
            }   
        }
        
        if(!flag)
            throw new AssertionError("Capacity of the zone is full! Cannot add animal!");
                
        return flag;
    }
    
    
    /**
     * This method will remove the animal from specific cage
     * @param animal
     * @return true if removed successfully, throws AssertionError otherwise
     */
    public boolean removeAnimal(AnimalType animal)
    {
        boolean removed = false;
        
        for(Cage cage: listOfCages)
        {
            if(cage.getAnimalType().equals(animal))
                removed = cage.removeAnimal();
        }
        
        return removed;
    }
}