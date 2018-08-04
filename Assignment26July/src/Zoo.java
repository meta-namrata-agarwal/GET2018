

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides various methods for Zoo management
 * @author Namrata
 */
public class Zoo {

    List<Zone> listOfZone = new ArrayList<Zone>(); 
    
    
    /**
     * This method add the zone for a specific category of animal
     * @param zoneType
     * @param capacity
     */
    public boolean addZone(AnimalCategory zoneType, int capacity)
    {
        Zone zone = null;
        
        switch(zoneType)
        {
        case BIRD:    zone = new BirdZone(capacity);
                      break;
        case MAMMAL:  zone = new MammalZone(capacity);
                      break;
        case REPTILE: zone = new ReptileZone(capacity);
                      break;        
        }
        
        listOfZone.add(zone);
        return true;
    }
    
    
    /**
     * This method will add cage to a particular zone
     * @param animal
     * @return true if cage is added, throws an AssertionError otherwise
     */
    public boolean addCage(AnimalType animal, int capacity)
    {
        Cage cage = new Cage(animal, capacity);
        boolean flag = false;
    
        for(Zone zone: listOfZone)
        {
            if(zone.spareCapacity() != 0)
            {
                
                if(zone.getZoneType() == AnimalCategory.BIRD && (animal.equals(AnimalType.PARROT) || animal.equals(AnimalType.PEACOCK)))
                {
                    zone.addCage(cage);
                    flag = true;
                    break;
                }
                else if(zone.getZoneType() == AnimalCategory.MAMMAL && (animal.equals(AnimalType.LION) || animal.equals(AnimalType.BEAR)))
                {
                    zone.addCage(cage);
                    flag = true;
                    break;
                }
                else if(zone.getZoneType() == AnimalCategory.REPTILE && (animal.equals(AnimalType.CROCODILE) || animal.equals(AnimalType.FROG)))
                {
                    zone.addCage(cage);
                    flag = true;
                    break;
                }   
            }           
        }
        
        if(!flag)
        {
            throw new AssertionError("You need to add a zone first!!");
        }
        return flag;
    }
    
    
    /**
     * This method adds the animal to a specific cage
     * @param animal 
     * @return true if added successfully, throws an AssertionError otherwise
     */
    public boolean addAnimal(Animal animal)
    {
        boolean flag = false;
        
        for(Zone zone: listOfZone)
        {
            if(zone.getZoneType().equals(animal.getCategory()) && zone.addAnimal(animal))
            {
                flag = true;
                break;
            }
        }
        
        if(!flag)
            throw new AssertionError("All zones are full!!You need to add a zone first!!");
        
        return flag;
    }
    
    
    /**
     * This method removes the specific animal from the cage if its present
     * @param animal takes the animal name, i.e Lion, Parrot, etc
     * @return true if animal is removed, throws AssertionError otherwise
     */
    public boolean removeAnimal(AnimalType animal)
    {
        boolean flag = false;
        AnimalCategory category = null;
        
        switch(animal)
        {
        case CROCODILE: category = AnimalCategory.REPTILE;
            break;
        case BEAR:category = AnimalCategory.MAMMAL;
            break;
        case LION:category = AnimalCategory.MAMMAL;
            break;
        case PARROT:category = AnimalCategory.BIRD;
            break;
        case PEACOCK:category = AnimalCategory.BIRD;
            break;
        case FROG:category = AnimalCategory.REPTILE;
            break;
        }
        
        for(Zone zone: listOfZone)
        {
            if(zone.getZoneType().equals(category) && zone.removeAnimal(animal))
            {
                flag = true;
                break;
            }
        }
        
        if(!flag)
            throw new AssertionError("Animal not found!");
        
        return flag;
    }
}