package Presenter;

import Model.*;
import View.AnimalRegistryView;
import View.ConsoleAnimalRegistryView;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AnimalRegistryPresenter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
            // Закройте Scanner после завершения программы
            view.closeScanner();
        }
    }


    private void onTeachAnimalCategoriesButtonClicked() {
        // Логика для обучения категориям животных
    }

    private void onDeleteAnimalButtonClicked() {
        // Логика для удаления животных
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
            // Выводим меню категорий животных
            view.showAnimalCategoriesMenu();

            String categoryChoice = view.getInput();

            switch (categoryChoice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    // Изменим вызов метода showAnimalList, чтобы он возвращал List<Map<String, Object>>
                    showAnimalList(categoryChoice);
                    break;
                case "7":
                    // Изменим вызов метода showAnimalList, чтобы он возвращал List<Map<String, Object>>
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

        // Заголовки таблицы
        String[] headers = {"ID", "Name", "Birth Date", "Category"};

        view.showAnimalList(animalList, headers);

        while (true) {
            view.showCommandsMenu();
            String commandsChoice = view.getInput();

            switch (commandsChoice) {
                case "1":
                    // Логика для отображения команд животных
                    view.showAnimalCommands(model.getAnimalCommands());
                    break;
                case "2":
                    return;
                default:
                    view.showErrorMessage("Invalid choice. Please try again.");
            }
        }
    }


    // В классе AnimalRegistryPresenter




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
            System.out.println(newId);

            // Получаем конструктор без параметров
            Constructor<? extends HumanFriends> constructor = animalClass.getDeclaredConstructor();

            // Используем конструктор без параметров
            HumanFriends newAnimal = constructor.newInstance();

            // Вводим данные для нового животного
            String name = view.getUserInputAnimalName(animalClass);
            Date birthDate = view.getUserInputAnimalBirthDate(animalClass);
            List<String> commands = view.getUserInputAnimalCommands(animalClass);

            // Заполняем данные для нового животного
            newAnimal.setId(newId);
            newAnimal.setName(name);
            newAnimal.setBirthDate(birthDate);
            newAnimal.setCommands(commands);

            // Добавляем новое животное в список
            AnimalRegistryModel.addNewAnimal(newAnimal);

            // Помечаем, что ресурс был закрыт успешно
            return newAnimal;
        } catch (Exception e) {
            // Перехватываем исключение Resource not closed properly и не выводим сообщение
            if (!"Resource not closed properly".equals(e.getMessage())) {
                view.showErrorMessage("Error creating animal: " + e.getMessage());
            }
            return null;
        }
    }

    private boolean areAllFieldsFilled(HumanFriends animal) {
        System.out.println(animal.getId() );
        System.out.println(animal.getName());
        System.out.println(animal.getBirthDate());
        System.out.println(animal.getCommands());
        // Здесь проверьте, что все необходимые поля объекта animal заполнены
        // Например, вам нужно проверить, что id, имя, дата рождения и команды не пусты
        return animal.getId() != 0 && !animal.getName().isEmpty() && animal.getBirthDate() != null && !animal.getCommands().isEmpty();
    }

}
