package View;

import Model.HumanFriends;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleAnimalRegistryView implements AnimalRegistryView {
    private final Scanner scanner;

    public ConsoleAnimalRegistryView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showAnimalCommands(List<String> commands) {
        System.out.println("Команды: " + commands);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Добавить животное");
        System.out.println("2. Удалить животное");
        System.out.println("3. Обучить животное");
        System.out.println("4. Показать животных");
        System.out.println("5. Выход");
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
    public void showAnimalList(List<Map<String, Object>> animalList) {

    }



    @Override
    public void showAnimalList(List<Map<String, Object>> animalList, String[] headers) {

        System.out.printf("%-5s | %-20s | %-15s | %-15s | %-30s\n", (Object[]) headers);


        for (Map<String, Object> animalInfo : animalList) {
            System.out.printf("%-5s | %-20s | %-15s | %-15s | %-30s\\n\n",
                    animalInfo.get("id"),
                    animalInfo.get("name"),
                    animalInfo.get("birthDate"),
                    animalInfo.get("category"),
                    animalInfo.get("commands"));
        }
    }




    @Override
    public void showCommandsMenu() {
        System.out.println("1. Показать команды животного ");
        System.out.println("2. Назад");
    }
    @Override
    public int getAnimalTypeChoice() {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Кошка");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел");

        return Integer.parseInt(scanner.nextLine());
    }
    @Override
    public String getUserInputAnimalName(Class<? extends HumanFriends> animalClass) {
        return getUserInput("Введите имя " + animalClass.getSimpleName() + ":");
    }

    @Override
    public Date getUserInputAnimalBirthDate(Class<? extends HumanFriends> animalClass) {
        return getUserInputDate("Введите дату рождения " + animalClass.getSimpleName() + " (в формате dd-MM-yyyy):");
    }

    @Override
    public List<String> getUserInputAnimalCommands(Class<? extends HumanFriends> animalClass) {
        return getUserInputCommands("Введите выполняемые команды " + animalClass.getSimpleName() + " (через запятую):");
    }
    public Date getUserInputDate(String prompt) {
        String userInput = getUserInput(prompt);

        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                return dateFormat.parse(userInput);
            } catch (ParseException e) {
                // Если введенная дата не соответствует формату, просим пользователя ввести ее заново
                System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате dd-MM-yyyy:");
                userInput = getUserInput(prompt);
            }
        }
    }
    public List<String> getUserInputCommands(String prompt) {
        String userInput = getUserInput(prompt);

        String[] commandsArray = userInput.split(",");
        List<String> commandsList = new ArrayList<>();

        for (String command : commandsArray) {
            commandsList.add(command.trim());
        }
        System.out.println(commandsList);
        return commandsList;
    }
    public String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    public void closeScanner() {
        scanner.close();
    }

    @Override

    public void showAnimalCategoriesMenu() {
        System.out.println("Выберите категорию животных:");
        System.out.println("1. Кошки");
        System.out.println("2. Собаки");
        System.out.println("3. Хомяки");
        System.out.println("4. Лошади");
        System.out.println("5. Верблюды");
        System.out.println("6. Ослы");
        System.out.println("7. Все животные");
        System.out.println("8. Назад");
    }
    @Override
    public int getUserInputAnimalIdToDelete() {
        System.out.println("Введите ID животного для удаления:");
        return Integer.parseInt(scanner.nextLine());
    }
    @Override
    public int getAnimalIdToTeach() {
        System.out.println("Введите ID животного для обучения:");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String getUserInputNewCommand() {
        System.out.println("Введите новую команду для обучения:");
        return scanner.nextLine();
    }
}
