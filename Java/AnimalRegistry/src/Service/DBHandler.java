package Service;



import Model.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;



import java.io.File;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DBHandler {

    private static final String DB_FILE_PATH = "animals.db";
    private static final String DATE_FORMAT_DB = "yyyy-MM-dd";;


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlite:" + DB_FILE_PATH;
        return DriverManager.getConnection(url);
    }


    public static void createDatabaseAndTables() {
        File dbFile = new File(DB_FILE_PATH);


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_PATH);
             Statement statement = connection.createStatement()) {


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS HumanFriends (" +
                    "id INTEGER PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "birthDate DATE NOT NULL," +
                    "commands JSON)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Pets (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES HumanFriends(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Cat (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Dog (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Hamster (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PackAnimals (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES HumanFriends(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Horse (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Donkey (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE)");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Camel (" +
                    "id INTEGER PRIMARY KEY," +
                    "FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void loadFromDatabase(List<HumanFriends> animals) {
        try (Connection connection = DBHandler.getConnection();
             Statement statement = connection.createStatement()) {


            loadAnimalsFromTable(statement, "Cat", Cat.class, animals);
            loadAnimalsFromTable(statement, "Dog", Dog.class, animals);
            loadAnimalsFromTable(statement, "Hamster", Hamster.class, animals);
            loadAnimalsFromTable(statement, "Horse", Horse.class, animals);
            loadAnimalsFromTable(statement, "Donkey", Donkey.class, animals);
            loadAnimalsFromTable(statement, "Camel", Camel.class, animals);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error loading data from the database. Creating database and tables...");
            createDatabaseAndTables();
        }
    }

    private static <T extends HumanFriends> void loadAnimalsFromTable(Statement statement, String tableName, Class<T> animalClass, List<HumanFriends> animals) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");

            try (Statement secondStatement = statement.getConnection().createStatement()) {
                ResultSet resultSetHumanFriends = secondStatement.executeQuery("SELECT * FROM HumanFriends WHERE id = " + id);
                if (resultSetHumanFriends.next()) {
                    String name = resultSetHumanFriends.getString("name");
                    Date birthDate = new Date(parseDate(resultSetHumanFriends.getString("birthDate")).getTime());

                    String jsonCommands = resultSetHumanFriends.getString("commands");
                    List<String> commands = parseJsonCommands(jsonCommands);

                    try {
                        T animal = animalClass.getDeclaredConstructor(int.class, String.class, Date.class, List.class)
                                .newInstance(id, name, birthDate, commands);

                        animals.add(animal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Ошибка: не найдены данные для " + tableName + " с id=" + id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    private static List<String> parseJsonCommands(String jsonCommands) {
        List<String> commandsList = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(jsonCommands, JsonArray.class);

            if (jsonArray != null) {
                for (JsonElement jsonElement : jsonArray) {
                    commandsList.add(jsonElement.getAsString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return commandsList;
    }




    public static void saveToDatabase(List<HumanFriends> animals) {
        try (Connection connection = DBHandler.getConnection();
             Statement statement = connection.createStatement()) {


            statement.executeUpdate("DELETE FROM Cat");
            statement.executeUpdate("DELETE FROM Dog");
            statement.executeUpdate("DELETE FROM Hamster");
            statement.executeUpdate("DELETE FROM Horse");
            statement.executeUpdate("DELETE FROM Donkey");
            statement.executeUpdate("DELETE FROM Camel");
            statement.executeUpdate("DELETE FROM Pets");
            statement.executeUpdate("DELETE FROM PackAnimals");
            statement.executeUpdate("DELETE FROM HumanFriends");


            for (HumanFriends animal :animals ) {
                insertAnimalIntoTables(statement, animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertAnimalIntoTables(Statement statement, HumanFriends animal) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO HumanFriends (id, name, birthDate, commands) VALUES " +
                        "(" + animal.getId() + ", '" + animal.getName() + "', '" +
                        formatDateForDatabase(animal.getBirthDate())  + "', '" + convertCommandsToJson(animal.getCommands()) + "')");

        if (animal instanceof Pets) {
            insertAnimalIntoPetsTables(statement, (Pets) animal);
        } else if (animal instanceof PackAnimals) {
            insertAnimalIntoPackAnimalsTables(statement, (PackAnimals) animal);
        }
    }

    private static String formatDateForDatabase(java.util.Date birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(birthDate);
    }

    private static void insertAnimalIntoPetsTables(Statement statement, Pets animal) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO Pets (id) VALUES " +
                        "(" + animal.getId() + ")");

        if (animal instanceof Cat) {
            statement.executeUpdate(
                    "INSERT INTO Cat (id) VALUES " +
                            "(" + animal.getId() + ")");
        } else if (animal instanceof Dog) {
            statement.executeUpdate(
                    "INSERT INTO Dog (id) VALUES " +
                            "(" + animal.getId() + ")");
        } else if (animal instanceof Hamster) {
            statement.executeUpdate(
                    "INSERT INTO Hamster (id) VALUES " +
                            "(" + animal.getId() + ")");
        }

    }

    private static void insertAnimalIntoPackAnimalsTables(Statement statement, PackAnimals animal) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO PackAnimals (id) VALUES " +
                        "(" + animal.getId() + ")");

        if (animal instanceof Horse) {
            statement.executeUpdate(
                    "INSERT INTO Horse (id) VALUES " +
                            "(" + animal.getId() + ")");
        } else if (animal instanceof Camel) {
            statement.executeUpdate(
                    "INSERT INTO Camel (id) VALUES " +
                            "(" + animal.getId() + ")");
        } else if (animal instanceof Donkey) {
            statement.executeUpdate(
                    "INSERT INTO Donkey (id) VALUES " +
                            "(" + animal.getId() + ")");
        }

    }
    private static String convertCommandsToJson(List<String> commands) {
        Gson gson = new Gson();
        return gson.toJson(commands);
    }
    private static java.sql.Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DB);
            java.util.Date utilDate = dateFormat.parse(dateString);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }




}
