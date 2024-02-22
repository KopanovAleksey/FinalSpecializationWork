import java.time.LocalDate;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDate;

    public Animal(String name, LocalDate birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}


