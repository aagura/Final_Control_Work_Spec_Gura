package Model;

import java.util.Date;
import java.util.List;

public class Hamster extends Pets {
    public Hamster(int id, String name, Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
