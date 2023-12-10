package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Camel extends PackAnimals {
    public Camel(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Camel() {
        super(0, "", new Date(), new ArrayList<>());
    }
}
