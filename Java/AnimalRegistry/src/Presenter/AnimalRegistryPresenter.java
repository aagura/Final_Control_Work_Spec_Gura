package Presenter;

import Model.AnimalRegistryModel;
import Model.Counter;
import View.AnimalRegistryView;

import java.util.List;

public class AnimalRegistryPresenter {
    private final AnimalRegistryView view;
    private final AnimalRegistryModel model;

    public AnimalRegistryPresenter(AnimalRegistryView view, AnimalRegistryModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        while (true) {
            view.showMenu();
            String choice = view.getInput();

            switch (choice) {
                case "1":
                    onNewAnimalButtonClicked();
                    break;
                case "2":
                    onShowMenuButtonClicked();
                    break;
                case "3":
                    onShowAnimalCategoriesButtonClicked();
                    break;
                case "4":
                    return;
                default:
                    view.showErrorMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void onNewAnimalButtonClicked() {
        try (Counter counter = new Counter()) {
            view.showSuccessMessage("New animal created. Total animals: " + counter.getCount());
        } catch (Exception e) {
            view.showErrorMessage("Error creating animal: " + e.getMessage());
        }
    }

    private void onShowMenuButtonClicked() {
        // Logic for showing animal details and commands
        view.showSuccessMessage("Menu shown.");
    }

    private void onShowAnimalCategoriesButtonClicked() {
        while (true) {
            view.showAnimalList(List.of("Cat", "Dog", "Hamster", "Horse", "Donkey", "Camel", "All"));
            String categoryChoice = view.getInput();

            switch (categoryChoice) {
                case "1":
                    showAnimalList("Cat");
                    break;
                case "2":
                    showAnimalList("Dog");
                    break;
                case "3":
                    showAnimalList("Hamster");
                    break;
                case "4":
                    showAnimalList("Horse");
                    break;
                case "5":
                    showAnimalList("Donkey");
                    break;
                case "6":
                    showAnimalList("Camel");
                    break;
                case "7":
                    showAnimalList("All");
                    break;
                case "8":
                    return;
                default:
                    view.showErrorMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void showAnimalList(String category) {
        // Logic to fetch and display animals of the specified category
        List<String> animalList = model.getAnimalList(category);
        view.showAnimalList(animalList);

        while (true) {
            view.showCommandsMenu();
            String commandsChoice = view.getInput();

            switch (commandsChoice) {
                case "1":
                    // Logic to show animal commands
                    view.showAnimalCommands(model.getAnimalCommands());
                    break;
                case "2":
                    return;
                default:
                    view.showErrorMessage("Invalid choice. Please try again.");
            }
        }
    }
}
