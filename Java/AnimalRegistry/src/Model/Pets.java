package Model;

import java.util.Date;
import java.util.List;

public class Pets extends HumanFriends {
    public Pets(int id, String name, Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
}
