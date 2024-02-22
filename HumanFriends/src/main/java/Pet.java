import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Pet extends Animal {
    protected ArrayList<String> commands;
    public  Pet(String name, LocalDate birthDate){
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
