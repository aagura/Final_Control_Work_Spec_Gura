package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Horse extends PackAnimals {
    public Horse(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Horse() {
        super(0, "", new Date(), new ArrayList<>());
    }
}

