package Model;
import java.util.Date;
import java.util.List;

public class Cat extends Pets {
    public Cat(int id, String name, Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
