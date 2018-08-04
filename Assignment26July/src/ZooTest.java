import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ZooTest {

    @Test
    public void addZoneTest() {
        Zoo zoo = new Zoo();
        assertTrue(zoo.addZone(AnimalCategory.MAMMAL, 2));
        assertTrue(zoo.addZone(AnimalCategory.BIRD, 2));
        assertTrue(zoo.addZone(AnimalCategory.REPTILE, 2));
        assertTrue(zoo.addZone(AnimalCategory.BIRD, 2));
    }

    /**
     * test for adding cage in the zoo when compatible zone is present
     */
    @Test
    public void addCageTest1() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.MAMMAL, 2);
        assertTrue(zoo.addCage(AnimalType.LION, 3));
    }

    /**
     * test for adding cage in the zoo when compatible zone is not present
     */
    @Test//(expected = AssertionError.class)
    public void addCageTest2() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.BIRD, 2);
        zoo.addCage(AnimalType.LION, 3);
    }

    /**
     * test for adding cages in the zoo exceeding the capacity of the zone
     */
    @Test//(expected = AssertionError.class)
    public void addCageTest3() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.MAMMAL, 2);
        zoo.addCage(AnimalType.LION, 3);
        zoo.addCage(AnimalType.LION, 3);
        zoo.addCage(AnimalType.LION, 3);
    }

    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage
     * is present
     */
    @Test
    public void addAnimalTest1() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.MAMMAL, 2);
        zoo.addCage(AnimalType.LION, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }

    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage
     * is not present
     */
    @Test//(expected = AssertionError.class)
    public void addAnimalTest2() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.MAMMAL, 2);
        zoo.addCage(AnimalType.BEAR, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }

    /**
     * test to remove an animal from the zoo when it is present
     */
    @Test
    public void removeAnimalTest() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalCategory.MAMMAL, 2);
        zoo.addCage(AnimalType.LION, 3);
        zoo.addAnimal(new Lion(25, 12));
        assertTrue(zoo.removeAnimal(AnimalType.LION));
    }

}
