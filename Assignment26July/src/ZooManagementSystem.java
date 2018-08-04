
import java.util.Scanner;

/**
 * This is the main method from where zoo management system is managed
 * @author Namrata Agarwal
 */
public class ZooManagementSystem {

    public static void main(String[] args) {

        Zoo zoo = new Zoo(); //  object of zoo class
        int choice;
        
        // a while loop which is true for each situation
        do
        {
            System.out.println("MENU!!!!");
            System.out.println("1. Add Zone to the Zoo");
            System.out.println("2. Add Cage to the Zone");
            System.out.println("3. Add Animal to cage");
            System.out.println("4. Remove animal from cage");
            System.out.println("5. Exit");
            
            System.out.println("Enter your choice..");
            Scanner scanner = new Scanner(System.in);
            
            while(!scanner.hasNextInt())
            {
                System.out.println("Please enter integer value");
                scanner.next();
            }
            choice = scanner.nextInt();
            
            switch (choice) 
            {
            case 1: AnimalCategory zoneType = chooseZone(scanner);
                    System.out.println("Please enter the capacity");
                    int capacity = scanner.nextInt();
                    zoo.addZone(zoneType, capacity);
                    break;
            
            case 2: AnimalType cageType = chooseCage(scanner);
                    System.out.println("Enter the capacity of the cage");
                    int capacityOfCage = scanner.nextInt();
        
                    if(zoo.addCage(cageType, capacityOfCage))
                    {
                        System.out.println("Cage is successfully added");
                    }
                    break;
            
            case 3: AnimalType animalType = chooseCage(scanner);
                    Animal animal = addNewAnimal(scanner, animalType);
                    if(zoo.addAnimal(animal))
                        System.out.println("Animal added successfully");
                    break;
            
            case 4: AnimalType animalType1 = chooseCage(scanner);
                    if(zoo.removeAnimal(animalType1))
                        System.out.println("Remove successfully");
                    break;
                    
            case 5: break;
            
            default:System.out.println("Wrong input! Try again!");
            
            }
        }while(choice != 5);
    }
    

    /**
     * This will create a animal object to add animal
     * @param scanner object
     * @param animalType
     * @return animal object
     */
    private static Animal addNewAnimal(Scanner sc, AnimalType animalType) {
        
        Animal animal = null;
        double weight;
        int age;
        double wingSpan;
        switch(animalType)
        {
        case CROCODILE: System.out.println("Enter the weight and age of crocodile");
             weight = sc.nextDouble();
             age = sc.nextInt();
             animal = new Crocodile(weight, age);
             break;
            
        case BEAR: System.out.println("Enter the weight and age of bear");
             weight = sc.nextDouble();
             age = sc.nextInt();
             animal = new Bear(weight, age);
             break;
            
        case LION: System.out.println("Enter the weight and age of Lion");
             weight = sc.nextDouble();
             age = sc.nextInt();
             animal = new Lion(weight, age);
             break;
            
        case PARROT: System.out.println("Enter the weight, age and wing span of Parrot");
             weight = sc.nextDouble();
             age = sc.nextInt();
             wingSpan = sc.nextDouble();
             animal = new Parrot(weight, age, wingSpan);
             break;
            
        case PEACOCK:System.out.println("Enter the weight, age and wing span of Peacock");
             weight = sc.nextDouble();
             age = sc.nextInt();
             wingSpan = sc.nextDouble();
             animal = new Peacock(weight, age, wingSpan);
             break;
            
        case FROG: System.out.println("Enter the weight and age of snake");
             weight = sc.nextDouble();
             age = sc.nextInt();
             animal = new Frog(weight, age);
             break;
            
        }
        return animal;
    }
    

    /**
     * Used to find animal name
     * @param sc
     * @return
     */
    private static AnimalType chooseCage(Scanner sc) {
        AnimalType cageType = null;
        System.out.println("List of Cage Types");
        System.out.println("1. Lion");
        System.out.println("2. Elephant");
        System.out.println("3. Parrot");
        System.out.println("4. Peacock");
        System.out.println("5. Snake");
        System.out.println("6. Crocodile");
        System.out.println("Choose from the cage types..");
        
        int cage = sc.nextInt();
        
        switch(cage)
        {
        case 1: 
            cageType = AnimalType.LION;
            break;
        case 2: 
            cageType = AnimalType.BEAR;
            break;
        case 3: 
            cageType = AnimalType.PARROT;
            break;
        case 4: 
            cageType = AnimalType.PEACOCK;
            break;
        case 5: 
            cageType = AnimalType.FROG;
            break;
        case 6: 
            cageType = AnimalType.CROCODILE;
            break;
        default:
            System.out.println("No result found!!");
            break;  
        }
        return cageType;
    }

    
    /**
     * this method is used to choose the category of the animal
     * @param sc
     * @return
     */
    private static AnimalCategory chooseZone(Scanner sc) {
        
        AnimalCategory zoneType = null;
        System.out.println("List of Zones");
        System.out.println("1. Bird");
        System.out.println("2. Mammal");
        System.out.println("3. Reptile");
        System.out.println("Choose from the zone types..");
        
        int zone = sc.nextInt();
        
        switch (zone) {
        case 1:
            zoneType = AnimalCategory.BIRD;
            break;
        case 2:
            zoneType = AnimalCategory.MAMMAL;
            break;
        case 3:
            zoneType = AnimalCategory.REPTILE;
            break;
        default:
            System.out.println("No result found!!");
            break;
        }
        return zoneType;
    }

}