package Model;

import java.util.Date;
import java.util.List;

public class Dog extends Pets {
    public Dog(int id, String name, Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
