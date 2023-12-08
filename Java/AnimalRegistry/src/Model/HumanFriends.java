package Model;

import java.util.Date;
import java.util.List;

public class HumanFriends {
    private int id;
    private String name;
    private Date birthDate;
    private List<String> commands;

    public HumanFriends(int id, String name, Date birthDate, List<String> commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }
}
