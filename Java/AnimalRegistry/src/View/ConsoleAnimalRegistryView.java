package View;

import java.util.Scanner;
import java.util.List;

public class ConsoleAnimalRegistryView implements AnimalRegistryView {
    private final Scanner scanner;

    public ConsoleAnimalRegistryView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showAnimalCommands(List<String> commands) {
        System.out.println("Animal commands: " + commands);
    }

    @Override
    public void showMenu() {
        System.out.println("1. New Animal");
        System.out.println("2. Show Menu");
        System.out.println("3. Show Animal Categories");
        System.out.println("4. Exit");
    }

    @Override
    public void showErrorMessage(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public void showSuccessMessage(String message) {
        System.out.println("Success: " + message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void showAnimalList(List<String> animalList) {
        System.out.println("Animal List:");
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println((i + 1) + ". " + animalList.get(i));
        }
    }

    @Override
    public void showCommandsMenu() {
        System.out.println("1. Show Animal Commands");
        System.out.println("2. Back");
    }
}
