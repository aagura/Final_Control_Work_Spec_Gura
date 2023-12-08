package Model;

import java.util.Date;
import java.util.List;

public class Horse extends PackAnimals {
    public Horse(int id, String name, Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}

