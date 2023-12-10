package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dog extends Pets {
    public Dog(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Dog() {
        super(0, "", new Date(), new ArrayList<>());
    }
}
