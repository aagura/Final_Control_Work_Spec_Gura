package View;

import Model.HumanFriends;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AnimalRegistryView {
    void showAnimalCommands(List<String> commands);

    void showMenu();

    void showErrorMessage(String message);

    void showSuccessMessage(String message);

    String getInput();

    void showAnimalList(List<Map<String, Object>> animalList);

    void showAnimalList(List<Map<String, Object>> animalList, String[] headers);

    void showCommandsMenu();

    int getAnimalTypeChoice();

    String getUserInputAnimalName(Class<? extends HumanFriends> animalClass);

    Date getUserInputAnimalBirthDate(Class<? extends HumanFriends> animalClass);

    List<String> getUserInputAnimalCommands(Class<? extends HumanFriends> animalClass);

    void closeScanner();

    void showAnimalCategoriesMenu();
}
