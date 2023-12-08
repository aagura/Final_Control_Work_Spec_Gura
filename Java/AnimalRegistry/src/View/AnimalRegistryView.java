package View;

import java.util.List;

public interface AnimalRegistryView {
    void showAnimalCommands(List<String> commands);

    void showMenu();

    void showErrorMessage(String message);

    void showSuccessMessage(String message);

    String getInput();

    void showAnimalList(List<String> animalList);

    void showCommandsMenu();
}
