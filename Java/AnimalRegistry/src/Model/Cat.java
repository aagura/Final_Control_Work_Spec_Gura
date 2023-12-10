package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cat extends Pets {
    public Cat(int id, String name, java.sql.Date birthDate, List<String> commands) {
        super(id, name, birthDate, commands);
    }
    public Cat() {
        super(0, "", new Date(), new ArrayList<>());
    }
}
