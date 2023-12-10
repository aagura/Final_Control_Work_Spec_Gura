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
            return 0;
        }

        int maxId =0;
        for (HumanFriends animal : animals) {
            if (animal.getId() > maxId) {
                maxId = animal.getId();

            }
        }

        return maxId;
    }




    public List<Map<String, Object>> getAnimalsByCategoryList(String category) {
        List<Map<String, Object>> animalList = new ArrayList<>();
        for (HumanFriends animal : animals) {
            if (category.equals("All") || animal.getClass().getSimpleName().equals(category)) {
                Map<String, Object> animalInfo = new HashMap<>();
                animalInfo.put("id", animal.getId());
                animalInfo.put("name", animal.getName());
                animalInfo.put("birthDate", animal.getBirthDate());
                animalInfo.put("category", animal.getClass().getSimpleName());

                animalInfo.put("commands", ((HumanFriends) animal).getCommands());


                animalList.add(animalInfo);
            }
        }
        return animalList;
    }


    public void loadFromDatabase() {
        try {
            DBHandler.loadFromDatabase(animals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try {
            DBHandler.saveToDatabase(animals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void removeAnimalById(int animalId) {

        animals.removeIf(animal -> animal.getId() == animalId);
    }
    public boolean animalExists(int animalId) {

        return animals.stream().anyMatch(animal -> animal.getId() == animalId);
    }
    public void teachAnimal(int animalId, String newCommand) {
        for (HumanFriends animal : animals) {
            if (animal.getId() == animalId) {

                animal.addCommand(newCommand);
                break;
            }
        }
    }




}



