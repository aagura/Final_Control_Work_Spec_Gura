package Model;

import Service.DBHandler;

import java.util.*;

public class AnimalRegistryModel {
    private static List<HumanFriends> animals;

    public AnimalRegistryModel() {
        this.animals = new ArrayList<>();
    }

    public static void addNewAnimal(HumanFriends newAnimal) {
        animals.add(newAnimal);
    }

    public static int findMaxId() {
        if (animals.isEmpty()) {
            System.out.println(0);
            return 0;
        }

        int maxId =0;
        for (HumanFriends animal : animals) {
            if (animal.getId() > maxId) {
                maxId = animal.getId();
                System.out.println(maxId);
            }
        }

        return maxId;
    }



    // В классе AnimalRegistryModel
    public List<Map<String, Object>> getAnimalsByCategoryList(String category) {
        List<Map<String, Object>> animalList = new ArrayList<>();
        for (HumanFriends animal : animals) {
            if (category.equals("All") || animal.getClass().getSimpleName().equals(category)) {
                Map<String, Object> animalInfo = new HashMap<>();
                animalInfo.put("id", animal.getId());
                animalInfo.put("name", animal.getName());
                animalInfo.put("birthDate", animal.getBirthDate());
                animalInfo.put("category", animal.getClass().getSimpleName());
                animalList.add(animalInfo);
            }
        }
        return animalList;
    }




    public List<String> getAnimalCommands() {
        // Логика получения списка команд для выбранного животного
        // ...
        return new ArrayList<>();
    }
    public void loadFromDatabase() {
        try {
            DBHandler.loadFromDatabase(animals); // Загрузим данные из базы данных
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для сохранения данных в файл
    public void saveToFile() {
        try {
            DBHandler.saveToDatabase(animals); // Сохраним данные в базу данных
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<HumanFriends> getAnimals() {
        return animals;
    }

    public List<HumanFriends> getAnimalsByCategory(String category) {
        List<HumanFriends> animalsByCategory = new ArrayList<>();
        for (HumanFriends animal : animals) {
            if (category.equals("All") || animal.getClass().getSimpleName().equals(category)) {
                animalsByCategory.add(animal);
            }
        }
        return animalsByCategory;
    }

}

