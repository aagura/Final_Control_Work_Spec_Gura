package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hamster extends Pets {
    public Hamster(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Hamster() {
        super(0, "", new Date(), new ArrayList<>());
    }
}
