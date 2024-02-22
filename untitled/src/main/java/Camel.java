import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends PackAnimal{
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public ArrayList<String> getCommands() {
        return super.getCommands();
    }

    @Override
    public void setCommands(ArrayList<String> commands) {
        super.setCommands(commands);
    }
}
