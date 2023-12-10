package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donkey extends PackAnimals {
    public Donkey(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Donkey () {
        super(0, "", new Date(), new ArrayList<>());
    }
}
