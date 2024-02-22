import java.time.LocalDate;
import java.util.ArrayList;

public abstract class PackAnimal extends Animal {
    protected ArrayList<String> commands;
    public PackAnimal(String name, LocalDate birthDate){
        super(name, birthDate);
        this.commands = new ArrayList<>();
    }

    public ArrayList<String> getCommands() {
        return commands;
    }
    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}
