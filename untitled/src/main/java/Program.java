import java.util.Scanner;

public class Program {
    static AnimalRegistry animalRegistry = new AnimalRegistry();

    public static void main(String[] args) {
/*
        try (Counter counter = new Counter()){
            counter.add();
            counter.close();
            counter.add();
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
 */
        navigateMenu();
    }
    public static void navigateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Animal Registry!");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new animal");
            System.out.println("2. Show animals commands");
            System.out.println("3. Train animal");
            System.out.println("4. Show animals count");
            System.out.println("5. Show all animals");
            System.out.println("0. Exit\n");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1 -> animalRegistry.addNewAnimal();
                case 2 -> animalRegistry.showAnimalCommands();
                case 3 -> animalRegistry.trainAnimal();
                case 4 -> animalRegistry.showAnimalCount();
                case 5 -> animalRegistry.showAllAnimals();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

}

