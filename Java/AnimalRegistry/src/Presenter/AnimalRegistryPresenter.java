package Presenter;

import Model.*;
import View.AnimalRegistryView;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AnimalRegistryPresenter {

    private final AnimalRegistryView view;
    private final AnimalRegistryModel model;

    public AnimalRegistryPresenter(AnimalRegistryView view, AnimalRegistryModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        try {
            model.loadFromDatabase();
            while (true) {
                view.showMenu();
                String choice = view.getInput();
                switch (choice) {
                    case "1":
                        onNewAnimalButtonClicked();
                        break;
                    case "2":
                        onDeleteAnimalButtonClicked();
                        break;
                    case "3":
                        onTeachAnimalCategoriesButtonClicked();
                        break;
                    case "4":
                        onShowAnimalCategoriesButtonClicked();
                        break;
                    case "5":
                        model.saveToFile();
                        return;
                    default:
                        view.showErrorMessage("Вы ошиблись. Повторите выбор");
                }
            }
        } finally {

            view.closeScanner();
        }
    }





    private void onNewAnimalButtonClicked() {
        try (Counter counter = new Counter()) {
            HumanFriends newAnimal = addAnimal(getAnimalClass());

            if (newAnimal != null && areAllFieldsFilled(newAnimal)) {
                counter.add();
                view.showSuccessMessage("New animal created. Total animals: " + counter.getCount());
            } else {
                view.showErrorMessage("Error creating animal.");
            }
        } catch (Exception e) {
            view.showErrorMessage("Error creating animal: " + e.getMessage());
        }
    }

    private void onShowAnimalCategoriesButtonClicked() {
        while (true) {
            view.showAnimalCategoriesMenu();
            String categoryChoice = view.getInput();

            switch (categoryChoice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    showAnimalList(getCategoryByChoice(categoryChoice));
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
        List<Map<String, Object>> animalList = model.getAnimalsByCategoryList(category);
        String[] headers = {"ID", "Name", "Birth Date", "Category","Commands"};

        view.showAnimalList(animalList, headers);



    }


    private Class<? extends HumanFriends> getAnimalClass() {
        int animalTypeChoice = view.getAnimalTypeChoice();

        switch (animalTypeChoice) {
            case 1:
                return Cat.class;
            case 2:
                return Dog.class;
            case 3:
                return Hamster.class;
            case 4:
                return Horse.class;
            case 5:
                return Camel.class;
            case 6:
                return Donkey.class;
            default:
                view.showErrorMessage("Вы ошиблись. Повторите выбор");
                return null;
        }
    }

    private HumanFriends addAnimal(Class<? extends HumanFriends> animalClass) {
        try  {
            int newId = model.findMaxId() + 1;

            Constructor<? extends HumanFriends> constructor = animalClass.getDeclaredConstructor();

            HumanFriends newAnimal = constructor.newInstance();

            String name = view.getUserInputAnimalName(animalClass);
            Date birthDate = view.getUserInputAnimalBirthDate(animalClass);
            List<String> commands = view.getUserInputAnimalCommands(animalClass);

            newAnimal.setId(newId);
            newAnimal.setName(name);
            newAnimal.setBirthDate(birthDate);
            newAnimal.setCommands(commands);


            AnimalRegistryModel.addNewAnimal(newAnimal);

            return newAnimal;
        } catch (Exception e) {

            if (!"Resource not closed properly".equals(e.getMessage())) {
                view.showErrorMessage("Error creating animal: " + e.getMessage());
            }
            return null;
        }
    }

    private boolean areAllFieldsFilled(HumanFriends animal) {
        return animal.getId() != 0 && !animal.getName().isEmpty() && animal.getBirthDate() != null && !animal.getCommands().isEmpty();
    }
    private String getCategoryByChoice(String choice) {
        switch (choice) {
            case "1":
                return "Cat";
            case "2":
                return "Dog";
            case "3":
                return "Hamster";
            case "4":
                return "Horse";
            case "5":
                return "Donkey";
            case "6":
                return "Camel";
            case "7":
                return "All";
            case "8":
                return "Exit;";
            default:
                return null;
        }
    }

    private void onDeleteAnimalButtonClicked() {

        showAnimalList("All");
        int animalIdToDelete = view.getUserInputAnimalIdToDelete();


        if (model.animalExists(animalIdToDelete)) {
            model.removeAnimalById(animalIdToDelete);
            view.showSuccessMessage("Animal with ID " + animalIdToDelete + " has been removed.");
        } else {
            view.showErrorMessage("Animal with ID " + animalIdToDelete + " not found.");
        }
    }
    private void onTeachAnimalCategoriesButtonClicked() {
        while (true) {
            showAnimalList("All");

            int animalIdToTeach = view.getAnimalIdToTeach();
            if (!model.animalExists(animalIdToTeach)) {
                view.showErrorMessage("Животное с ID " + animalIdToTeach + " не найдено. Повторите ввод.");
                break;
            }

            String newCommand = view.getUserInputNewCommand();
            model.teachAnimal(animalIdToTeach, newCommand);
            view.showSuccessMessage("Животное обучено новой команде. Новая команда: " + newCommand);
            break;
        }
    }


}
