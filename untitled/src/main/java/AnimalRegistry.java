import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private ArrayList<Animal> animals;
    private Counter counter;

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public int getCounter() {
        return counter.getCount();
    }

    public AnimalRegistry(){
        animals = new ArrayList<>();
        counter = new Counter();
    }

    public void addAnimal(Animal newAnimal){
        getAnimals().add(newAnimal);
        counter.add();
    }

    private ArrayList<String> getAnimalCommands(Animal animal){
        if (animal instanceof Pet) {
            return ((Pet) animal).getCommands();
        }
        else if (animal instanceof PackAnimal) {
            return ((PackAnimal) animal).getCommands();
        }
        return null;
    }

    private void trainAnimalNewCommands(Animal animal, ArrayList<String> newCommands){
        if (animal instanceof Pet){
            ((Pet) animal).getCommands().addAll(newCommands);
        } else if (animal instanceof PackAnimal) {
            ((PackAnimal) animal).getCommands().addAll(newCommands);
        }
        else System.out.println("You can't train this animal");
    }

    public void trainAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter animal name:");
        String name = scanner.nextLine();

        Animal animal = findAnimalByName(name);
        if (animal == null) {
            System.out.println("Animal not found.");
        } else {
            System.out.println("Enter new commands (separated by comma):");
        }
        ArrayList<String> commands = new ArrayList<>(List.of(scanner.nextLine().split(",")));
        trainAnimalNewCommands(animal, commands);
        System.out.println("Animal trained successfully!");
    }

    public void addNewAnimal(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter animal type (Dog, Cat, Hamster, Horse, Camel, Donkey):");
            String type = scanner.nextLine();
            System.out.println("Enter animal name:");
            String name = scanner.nextLine();
            System.out.println("Enter animal birth date (YYYY-MM-DD):");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());
            Animal animal;
            switch (type) {
                case "Dog" -> animal = new Dog(name, birthDate);
                case "Cat" -> animal = new Cat(name, birthDate);
                case "Hamster" -> animal = new Hamster(name, birthDate);
                case "Horse" -> animal = new Horse(name, birthDate);
                case "Camel" -> animal = new Camel(name, birthDate);
                case "Donkey" -> animal = new Donkey(name, birthDate);
                default -> {
                    System.err.println("Unknown animal type.");
                    return;
                }
            }
            addAnimal(animal);
            System.out.println("Animal added successfully!");
        } catch (DateTimeParseException e){
            System.err.println("Enter correct date format");
        }
    }

    public void showAnimalCommands(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter animal name:");
        String name = scanner.nextLine();
        Animal animal = findAnimalByName(name);
        if (animal == null){
            System.err.println("Animal not found.");
        }
        else if (getAnimalCommands(animal).size() == 0) {
            System.out.println("This animal can't follow commands.");
        }
        else{
            System.out.println(getAnimalCommands(animal).toString());
        }
    }

    private Animal findAnimalByName(String name){
        for (Animal animal: this.animals) {
            if(animal.getName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public void showAnimalCount(){
        System.out.println(getCounter());
    }

    public void showAllAnimals(){
        int number = 1;
        System.out.println("№ Name Class BirthDate Commands\t");
        for (Animal animal: getAnimals()) {
            System.out.printf("%d %s %s %s %s\t\n", number, animal.getName(),
                    getAnimalClass(animal), animal.getBirthDate(), getAnimalCommands(animal));
            number++;
        }
    }

    private String getAnimalClass(Animal animal){
        return animal.getClass().getName();
    }
}
